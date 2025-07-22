package core;

import java.util.UUID;

public class CommonActions {

    /**
     * Generates a random email with the format: random-<uuid>@mailinator.com
     */
    public static String generateRandomEmail() {
        return "random-" + UUID.randomUUID().toString().substring(0, 8) + "@mailinator.com";
    }
}
