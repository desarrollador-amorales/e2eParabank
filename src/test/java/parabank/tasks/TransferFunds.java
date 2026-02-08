package parabank.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import parabank.ui.HomePage;
import parabank.ui.TransferFundsPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TransferFunds implements Task {

    private final String amount;

    public TransferFunds(String amount) {
        this.amount = amount;
    }

    public static TransferFunds amount(String amount) {
        return instrumented(TransferFunds.class, amount);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("Desde cuenta: " + TransferFundsPage.FROM_ACCOUNT);
        System.out.println("Hasta cuenta: " + TransferFundsPage.TO_ACCOUNT);

        actor.attemptsTo(
                Click.on(HomePage.TRANSFER_LINK),
                Enter.theValue(amount).into(TransferFundsPage.AMOUNT),
                // Por índice: 0=primera cuenta, 1=segunda cuenta
                SelectFromOptions.byIndex(0).from(TransferFundsPage.FROM_ACCOUNT),
                SelectFromOptions.byIndex(1).from(TransferFundsPage.TO_ACCOUNT),
                Click.on(TransferFundsPage.TRANSFER_BUTTON)
        );
    }
}
