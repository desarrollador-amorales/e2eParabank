package parabank.ui;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage {
    private RegisterPage() { }

    public static final Target FIRST_NAME = Target.the("First Name")
            .locatedBy("#customer\\.firstName");

    public static final Target LAST_NAME = Target.the("Last Name")
            .locatedBy("#customer\\.lastName");

    public static final Target ADDRESS = Target.the("Address")
            .locatedBy("#customer\\.address\\.street");

    public static final Target CITY = Target.the("City")
            .locatedBy("#customer\\.address\\.city");

    public static final Target STATE = Target.the("State")
            .locatedBy("#customer\\.address\\.state");

    public static final Target ZIP = Target.the("Zip Code")
            .locatedBy("#customer\\.address\\.zipCode");

    public static final Target PHONE = Target.the("Phone")
            .locatedBy("#customer\\.phoneNumber");

    public static final Target SSN = Target.the("SSN")
            .locatedBy("#customer\\.ssn");

    public static final Target USERNAME = Target.the("Username")
            .locatedBy("#customer\\.username");

    public static final Target PASSWORD = Target.the("Password")
            .locatedBy("#customer\\.password");

    public static final Target CONFIRM = Target.the("Confirm Password")
            .locatedBy("#repeatedPassword");

    public static final Target REGISTER_BUTTON = Target.the("Register button")
            .locatedBy("#customerForm input[type='submit']");

}
