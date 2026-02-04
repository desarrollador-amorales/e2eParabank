package parabank.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import parabank.ui.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class,username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(HomePage.USERNAME_INPUT),
                Enter.theValue(password).into(HomePage.PASSWORD_INPUT),
                Click.on(HomePage.LOGIN_BUTTON)
        );
    }
}
