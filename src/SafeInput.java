import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String input = "";
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
        } while (input.trim().length() == 0);
        return input;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean valid = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                if (value >= low && value <= high) {
                    valid = true;
                } else {
                    System.out.println("Error: Input must be between " + low + " and " + high);
                }
            } else {
                System.out.println("Error: Invalid integer input");
                pipe.next(); // consume bad input
            }
            pipe.nextLine(); // clear buffer
        } while (!valid);
        return value;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input = "";
        boolean valid = false;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Error: Input does not match pattern");
            }
        } while (!valid);
        return input;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim().toUpperCase();
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }
}
