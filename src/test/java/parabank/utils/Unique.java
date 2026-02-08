package parabank.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Unique {
    private Unique() {}

    public static String suffix() {
        String unique = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        return unique;
    }
}
