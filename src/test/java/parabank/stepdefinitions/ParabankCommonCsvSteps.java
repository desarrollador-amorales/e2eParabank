package parabank.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import parabank.model.User;
import parabank.tasks.NavigateTo;
import parabank.utils.CsvDataLoader;
import parabank.utils.Unique;

import java.util.Map;

public class ParabankCommonCsvSteps {

    private static final String BASE_URL = "https://parabank.parasoft.com/parabank/";

    @Managed(driver = "chrome")
    WebDriver browser;

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("QA").can(BrowseTheWeb.with(browser));
    }

    @Given("el usuario navega a ParaBank")
    public void elUsuarioNavegaAParaBank() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(NavigateTo.parabankHome(BASE_URL));
    }

    @And("carga el usuario {string} desde {string}")
    public void cargaElUsuarioDesdeCsv(String userId, String resourcePath) {
        Map<String, String> row = CsvDataLoader.loadRowById(resourcePath, "id", userId);
        String run = Unique.suffix();
        String dynamicUsername = run + "_" +row.get("username");
        String dynamicPassword = run + "_" +row.get("password");

        User user = new User(
                row.get("firstName"),
                row.get("lastName"),
                row.get("address"),
                row.get("city"),
                row.get("state"),
                row.get("zipCode"),
                row.get("phone"),
                row.get("ssn"),
                dynamicUsername,
                dynamicPassword
        );

        // Guardamos el user en memoria de escenario (actor memory)
        OnStage.theActorInTheSpotlight().remember("user", user);
    }

    @And("carga la transferencia {string} desde {string}")
    public void cargaLaTransferenciaDesdeCsv(String transferId, String resourcePath) {
        Map<String, String> row = CsvDataLoader.loadRowById(resourcePath, "id", transferId);
        OnStage.theActorInTheSpotlight().remember("amount", row.get("amount"));
    }
}
