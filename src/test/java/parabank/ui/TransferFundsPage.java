package parabank.ui;

import net.serenitybdd.screenplay.targets.Target;

public class TransferFundsPage {
    private TransferFundsPage() { }

    public static final Target AMOUNT = Target.the("Transfer amount")
            .locatedBy("#amount");

    public static final Target FROM_ACCOUNT = Target.the("From account dropdown")
            .locatedBy("//*[@id=\"fromAccountId\"]");

    public static final Target TO_ACCOUNT = Target.the("To account dropdown")
            .locatedBy("//*[@id=\"toAccountId\"]");

    public static final Target TRANSFER_BUTTON = Target.the("Transfer button")
            .locatedBy("//*[@id=\"transferForm\"]/div[2]/input");

    public static final Target RESULT_MESSAGE = Target.the("Transfer result message")
            .locatedBy("#rightPanel .title");
}
