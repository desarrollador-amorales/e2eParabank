package parabank.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import parabank.model.User;
import parabank.questions.WelcomeMessage;
import parabank.tasks.Register;

public class ParabankRegisterCsvStepDefinitions {

    Actor actor = OnStage.theActorInTheSpotlight();
    User user = actor.recall("user");

    @When("el usuario se registra con el usuario cargado")
    public void elUsuarioSeRegistraConElUsuarioCargado() {
        actor.attemptsTo(Register.with(user));
    }

    @And("el usuario ya está registrado con el usuario cargado")
    public void elUsuarioYaEstaRegistradoConElUsuarioCargado() {
        //Actor actor = OnStage.theActorInTheSpotlight();
        //User user = actor.recall("user");

        actor.attemptsTo(Register.with(user));
        Ensure.that(WelcomeMessage.text()).contains("Welcome to ParaBank");
    }

     @Then("debe ver mensaje de bienvenida de ParaBank")
        public void debeVerMensajeDeBienvenida() {
        Ensure.that(WelcomeMessage.text()).contains("Welcome to ParaBank");
    }
}
