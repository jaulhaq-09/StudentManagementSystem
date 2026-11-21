package util;

import java.util.Scanner;

public class InputUtil {

    public static Scanner scanner = new Scanner(System.in);

    // Read integer safely
    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);

                return value;

            } catch (Exception e) {

                System.out.println("Invalid number. Please try again.");

            }

        }
    }

    public static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);
            if (value > 0) {
                return value;
            }
            System.out.println("Value must be greater than zero.");
        }
    }

    public static int readAge(String message) {
        while (true) {
            int value = readInt(message);
            if (value >= 1 && value <= 150) {
                return value;
            }
            System.out.println("Age must be between 1 and 150.");
        }
    }

    // Read non-empty string
    public static String readString(String message) {

        while (true) {

            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}