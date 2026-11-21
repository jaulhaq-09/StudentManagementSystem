package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerUtil {

    private static final String LOG_FILE = "system.log";

    public static void log(String message) {

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {

            String logEntry = LocalDateTime.now() + " - " + message + "\n";
            writer.write(logEntry);

        } catch (IOException e) {
            System.out.println("Error writing log.");
        }
    }
}