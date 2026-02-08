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
import parabank.tasks.NavigateTo;
import parabank.tasks.Register;
import parabank.utils.CsvDataLoader;

import java.util.Map;

public class ParabankRegisterCsvStepDefinitions {


    @When("el usuario se registra con el usuario cargado")
    public void elUsuarioSeRegistraConElUsuarioCargado() {

        Actor actor = OnStage.theActorInTheSpotlight();
        User user = actor.recall("user");

        actor.attemptsTo(Register.with(user));
    }

    @And("el usuario ya está registrado con el usuario cargado")
    public void elUsuarioYaEstaRegistradoConElUsuarioCargado() {
        Actor actor = OnStage.theActorInTheSpotlight();
        User user = actor.recall("user");

        actor.attemptsTo(Register.with(user));
        Ensure.that(WelcomeMessage.text()).contains("Welcome to ParaBank");
    }

     @Then("debe ver mensaje de bienvenida de ParaBank")
        public void debeVerMensajeDeBienvenida() {
        Ensure.that(WelcomeMessage.text()).contains("Welcome to ParaBank");
    }
}
