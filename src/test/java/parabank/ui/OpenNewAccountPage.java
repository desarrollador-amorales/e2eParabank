package parabank.ui;

import net.serenitybdd.screenplay.targets.Target;

public class OpenNewAccountPage {

    private OpenNewAccountPage() {}

    public static final Target CREATE_ACCOUNT = Target.the("Open New Account submit button")
            .locatedBy("#openAccountForm input.button[value='Open New Account']");

    public static final Target ACCOUNT_CREATION_CONFIRMATION = Target.the("Confirmation message for account creation")
            .locatedBy("#openAccountResult h1");
}
