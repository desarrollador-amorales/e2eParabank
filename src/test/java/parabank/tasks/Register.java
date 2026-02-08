package parabank.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import parabank.model.User;
import parabank.ui.HomePage;
import parabank.ui.RegisterPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Register implements Task {

    private final User user;

    public Register(User user) {

        this.user = user;
    }

    public static Register with(User user) {
        return instrumented(Register.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.REGISTER_LINK, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.REGISTER_LINK),
                WaitUntil.the(RegisterPage.FIRST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user.getFirstName()).into(RegisterPage.FIRST_NAME),
                Enter.theValue(user.getLastName()).into(RegisterPage.LAST_NAME),
                Enter.theValue(user.getAddress()).into(RegisterPage.ADDRESS),
                Enter.theValue(user.getCity()).into(RegisterPage.CITY),
                Enter.theValue(user.getState()).into(RegisterPage.STATE),
                Enter.theValue(user.getZipCode()).into(RegisterPage.ZIP),
                Enter.theValue(user.getPhone()).into(RegisterPage.PHONE),
                Enter.theValue(user.getSsn()).into(RegisterPage.SSN),
                Enter.theValue(user.getUsername()).into(RegisterPage.USERNAME),
                Enter.theValue(user.getPassword()).into(RegisterPage.PASSWORD),
                Enter.theValue(user.getPassword()).into(RegisterPage.CONFIRM),
                WaitUntil.the(RegisterPage.REGISTER_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(RegisterPage.REGISTER_BUTTON)
        );
    }
}
