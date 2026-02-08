package parabank.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    private HomePage() { }

    public static final Target REGISTER_LINK = Target.the("link Register")
            .locatedBy("a[href*='register.htm']");

    // Login panel (evitamos XPaths absolutos)
    public static final Target USERNAME_INPUT = Target.the("input username")
            .locatedBy("#loginPanel form input[name='username']");

    public static final Target PASSWORD_INPUT = Target.the("input password")
            .locatedBy("#loginPanel form input[name='password']");

    public static final Target LOGIN_BUTTON = Target.the("button login")
            .locatedBy("#loginPanel form input[type='submit']");

    public static final Target WELCOME_PANEL = Target.the("panel de bienvenida")
            .locatedBy("#leftPanel p small");

    public static final Target TRANSFER_LINK = Target.the("Transfer Funds link")
            .locatedBy("a[href*='transfer.htm']");
}
