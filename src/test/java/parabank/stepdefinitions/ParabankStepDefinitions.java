package parabank.stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import parabank.model.User;
import parabank.questions.TransferSuccessMessage;
import parabank.questions.WelcomeMessage;
import parabank.tasks.*;
import parabank.utils.TestData;


public class ParabankStepDefinitions {

    private static final String BASE_URL = "https://parabank.parasoft.com/parabank/";
    private Actor userActor;
    private User user;

    @Managed(driver = "chrome")
    WebDriver browser;

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        userActor = OnStage.theActorCalled("QA");
        userActor.can(BrowseTheWeb.with(browser));
        user = TestData.newRandomUser();
        userActor.attemptsTo(NavigateTo.parabankHome(BASE_URL));
    }

    @Given("el usuario se registra en ParaBank con datos válidos")
    public void elUsuarioSeRegistra() {
        userActor.attemptsTo(Register.with(user));
        // Validación mínima: estamos logueados o tenemos panel izquierdo con mensaje
        Ensure.that(WelcomeMessage.text()).contains("Welcome to ParaBank");
    }

    @When("el usuario inicia sesión con el usuario registrado")
    public void elUsuarioIniciaSesion() {
        // En ParaBank al registrarte normalmente quedas logueado.
        // Pero para cumplir el requisito, hacemos logout/login.
        // Logout está en el menú izquierdo "Log Out" (link contiene logout.htm)
        //Implemento logica dentro un task para el "Log Out"
        userActor.attemptsTo(
                Logout.fromParabank(),
                Login.withCredentials(user.getUsername(), user.getPassword())
        );

        Ensure.that(WelcomeMessage.text()).containsIgnoringCase(user.getUsername());
    }

    @And("transfiere {string} desde la primera cuenta a la segunda")
    public void transfiere(String amount) {
        // Haciendo relacion al usuario y contraseña con que el se realiza la prueba
        // se crea una cuenta nueva antes de poder transferir entre cuentas.
        userActor.attemptsTo(
                OpenNewAccount.onceCreatedSuccessfully(),
                TransferFunds.amount(amount)
        );
    }

    //Validaciones de confirmaciones
    @Then("debe ver mensajes de confirmación para retiro y transferencia")
    public void debeVerConfirmaciones() {
        Ensure.that(TransferSuccessMessage.text()).containsIgnoringCase("Transfer Complete!");
    }
}
