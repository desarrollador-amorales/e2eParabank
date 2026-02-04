package parabank.utils;



import parabank.model.User;

import java.util.UUID;

public class TestData {
    private TestData() { }

    public static User newRandomUser() {
        String unique = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        String username = "qa_" + unique;
        String password = "P@ssw0rd123";

        return new User(
                "QA", "Automation",
                "123 Main St", "Quito", "Pichincha",
                "170000", "0999999999",
                "123-45-6789",
                username, password
        );
    }
}
