package parabank.stepdefinitions;


import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import parabank.questions.TransferSuccessMessage;
import parabank.tasks.*;

import java.util.Map;
public class ParabankTransferCsvStepDefinitions {

    Actor useractor = OnStage.theActorInTheSpotlight();
    String amount = useractor.recall("amount");

    @And("el usuario crea una nueva cuenta para poder transferir")
    public void creaNuevaCuenta() {
        useractor.attemptsTo(OpenNewAccount.onceCreatedSuccessfully());
    }


    @When("el usuario transfiere el monto cargado desde la primera cuenta a la segunda")
    public void transfiereMontoCargado() {
        useractor.attemptsTo(TransferFunds.amount(amount));
    }

    @Then("debe ver confirmación de transferencia")
    public void verConfirmacionTransferencia() {
        Ensure.that(TransferSuccessMessage.text()).containsIgnoringCase("Transfer Complete!");
    }
}
