package parabank.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LeftMenu {
    private LeftMenu() {}

    public static final Target OPEN_NEW_ACCOUNT =
            Target.the("Open New Account link").locatedBy("a[href*='openaccount.htm']");

    public static final Target LOG_OUT =
            Target.the("Log Out link").locatedBy("a[href*='logout.htm']");
}
