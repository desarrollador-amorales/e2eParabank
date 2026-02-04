package parabank.questions;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import parabank.ui.TransferFundsPage;


public class TransferSuccessMessage implements Question<String> {

    public static TransferSuccessMessage text() {

        return new TransferSuccessMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(TransferFundsPage.RESULT_MESSAGE).answeredBy(actor);
    }
}
