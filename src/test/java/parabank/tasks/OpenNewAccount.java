package parabank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import parabank.ui.LeftMenu;
import parabank.ui.OpenNewAccountPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class OpenNewAccount implements Task {

    public static OpenNewAccount onceCreatedSuccessfully() {
        return instrumented(OpenNewAccount.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Abrir la pantalla "Open New Account"
                WaitUntil.the(LeftMenu.OPEN_NEW_ACCOUNT, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LeftMenu.OPEN_NEW_ACCOUNT),

                //Esperar a que el boton este presente para realizar el click
                WaitUntil.the(OpenNewAccountPage.CREATE_ACCOUNT, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(OpenNewAccountPage.CREATE_ACCOUNT),

                // Confirmación visible
                WaitUntil.the(OpenNewAccountPage.ACCOUNT_CREATION_CONFIRMATION, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}
