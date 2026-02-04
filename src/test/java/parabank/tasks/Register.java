package parabank.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import parabank.model.User;
import parabank.ui.HomePage;
import parabank.ui.RegisterPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

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
                Click.on(HomePage.REGISTER_LINK),
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
                Click.on(RegisterPage.REGISTER_BUTTON)
        );
    }
}
