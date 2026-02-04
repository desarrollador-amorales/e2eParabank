package parabank.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AccountsOverviewPage {
    private AccountsOverviewPage() { }

    public static final Target ACCOUNTS_TABLE = Target.the("Accounts table")
            .locatedBy("#accountTable");

    public static final Target FIRST_ACCOUNT_LINK = Target.the("First account link")
            .locatedBy("#accountTable tbody tr:nth-child(1) td:nth-child(1) a");

    public static final Target SECOND_ACCOUNT_LINK = Target.the("Second account link")
            .locatedBy("#accountTable tbody tr:nth-child(2) td:nth-child(1) a");
}
