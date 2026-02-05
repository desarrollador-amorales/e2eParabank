package parabank.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    private HomePage() { }

    public static final Target REGISTER_LINK = Target.the("link Register")
            .locatedBy("a[href*='register.htm']");

    public static final Target USERNAME_INPUT = Target.the("input username")
            .locatedBy("//*[@id=\"loginPanel\"]/form/div[1]/input");

    public static final Target PASSWORD_INPUT = Target.the("input password")
            .locatedBy("//*[@id=\"loginPanel\"]/form/div[2]/input");

    public static final Target LOGIN_BUTTON = Target.the("button login")
            .locatedBy("//*[@id=\"loginPanel\"]/form/div[3]/input");

    public static final Target WELCOME_PANEL = Target.the("panel de bienvenida")
            .locatedBy("#leftPanel p small");

    public static final Target ACCOUNTS_OVERVIEW_LINK = Target.the("Accounts Overview link")
            .locatedBy("a[href*='overview.htm']");

    public static final Target TRANSFER_LINK = Target.the("Transfer Funds link")
            .locatedBy("a[href*='transfer.htm']");

    public static final Target CREATE_ACCOUNT = Target.the("Open New Account")
            .locatedBy("//*[@id=\"openAccountForm\"]/form/div/input");

    public static final Target ACCOUNT_CREATION_CONFIRMATION = Target.the("Confirmation message for account creation")
            .locatedBy("//*[@id=\"openAccountResult\"]/h1");

}
