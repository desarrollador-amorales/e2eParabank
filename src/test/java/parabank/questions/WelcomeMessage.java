package parabank.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import parabank.ui.HomePage;

public class WelcomeMessage implements Question<String> {

    public static WelcomeMessage text() {
        return new WelcomeMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomePage.WELCOME_PANEL).answeredBy(actor);
    }
}
