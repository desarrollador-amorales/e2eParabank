package parabank.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import parabank.model.User;
import parabank.questions.WelcomeMessage;
import parabank.tasks.Login;
import parabank.tasks.Logout;
import parabank.tasks.NavigateTo;
import parabank.tasks.Register;
import parabank.utils.CsvDataLoader;

import java.util.Map;

public class ParabankLoginCsvStepDefinitions {

    @When("el usuario inicia sesión con el usuario cargado")
    public void elUsuarioIniciaSesionConUsuarioCargado() {
        // ParaBank suele dejarte logueado tras registro, hacemos logout/login para validar realmente login

        Actor actor = OnStage.theActorInTheSpotlight();
        User user = actor.recall("user");

        actor.attemptsTo(
                Logout.fromParabank(),
                Login.withCredentials(user.getUsername(), user.getPassword())
        );
    }

    @Then("debe ver el username en el panel de bienvenida")
    public void debeVerElUsernameEnBienvenida() {
        Actor actor = OnStage.theActorInTheSpotlight();
        User user = actor.recall("user");
        Ensure.that(WelcomeMessage.text()).containsIgnoringCase(user.getUsername());
    }
}
