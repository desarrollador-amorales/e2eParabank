package parabank.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import parabank.ui.LeftMenu;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Logout implements Task {

    public static Logout fromParabank() {
        return instrumented(Logout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LeftMenu.LOG_OUT, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LeftMenu.LOG_OUT)
        );
    }
}
