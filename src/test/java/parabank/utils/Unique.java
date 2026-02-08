package parabank.utils;

import java.util.UUID;

public class Unique {
    private Unique() {}

    public static String suffix() {
        String unique = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        return unique;
    }
}
