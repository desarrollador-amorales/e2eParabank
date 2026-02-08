package parabank.ui;

import net.serenitybdd.screenplay.targets.Target;

public class TransferFundsPage {
    private TransferFundsPage() { }

    public static final Target AMOUNT = Target.the("Transfer amount")
            .locatedBy("#amount");

    // Dropdowns (IDs estables, no necesitan XPath)
    public static final Target FROM_ACCOUNT = Target.the("From account dropdown")
            .locatedBy("#fromAccountId");

    public static final Target TO_ACCOUNT = Target.the("To account dropdown")
            .locatedBy("#toAccountId");

    // Botón (más estable: dentro del form por submit)
    public static final Target TRANSFER_BUTTON = Target.the("Transfer button")
            .locatedBy("#transferForm input[type='submit']");

    // Mensaje resultado
    public static final Target RESULT_MESSAGE = Target.the("Transfer result message")
            .locatedBy("#rightPanel .title");

    // (Opcional) para esperas más robustas: el formulario visible
    public static final Target TRANSFER_FORM = Target.the("Transfer form")
            .locatedBy("#transferForm");
}
