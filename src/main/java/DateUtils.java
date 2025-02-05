import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.*;

public class DateUtils {
    private static final Logger logger = LoggerUtil.getLogger();

    public static LocalDate inputDateOfBirthOrRetry(Scanner scanner, int maxRetryAttempts) {
        int attemptsLeft = maxRetryAttempts;
        while (attemptsLeft > 0) {
            String dateOfBirthInput = scanner.nextLine();
            logger.info("User entered date: " + dateOfBirthInput); // Log input attempt

            LocalDate dateOfBirth = getValidatedDateOfBirth(dateOfBirthInput);
            if (dateOfBirth == null) {
                attemptsLeft--;

                if (attemptsLeft > 0) {
                    logAndPrint("Invalid format, try again, use YYYY/MM/DD format, you have " + attemptsLeft + " attempts left.");
                }
            } else {
                return dateOfBirth;
            }
        }

        logAndPrint("Too many invalid attempts.");
        return null;
    }

    public static void validateAge (LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        var age = Period.between(dateOfBirth, currentDate).getYears();

        if (age >= 100) {
            logAndPrint("You are " + age + " years old, what is your secret?");
        } else if (dateOfBirth.equals(currentDate)) {
            logAndPrint("Are you sure you were born today?");
        } else if (dateOfBirth.isAfter(currentDate)) {
            logAndPrint("You are not born yet but you know how to program!");
        } else if (dateOfBirth.getMonth() == currentDate.getMonth() &&
                dateOfBirth.getDayOfMonth() == currentDate.getDayOfMonth()) {
            logAndPrint("Happy Birthday! You're turning " + age + " today!");
        } else {
            logAndPrint("You are " + age + " years old. Amazing achievement :)");
        }
    }

    private static LocalDate getValidatedDateOfBirth(String dateInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try {
            LocalDate parsedDate = LocalDate.parse(dateInput, formatter);
            //checking parser edge case when invalid date 29th February in non-leap year is parsed to 28th February
            if (isDateAdjustedByParser(dateInput, parsedDate, formatter)){
                return null; // Invalid date (e.g., 2001/02/29 became 2001/02/28)
            }

            return parsedDate;
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private static boolean isDateAdjustedByParser(String actualDateInput, LocalDate parsedDate, DateTimeFormatter formatter) {
        String expectedDateInput = parsedDate.format(formatter);
        return !expectedDateInput.equals(actualDateInput);
    }

    private static void logAndPrint(String message) {
        System.out.println(message);
        logger.info(message);  // Logs to file, not terminal
    }

    public static boolean wantToRestart(Scanner scanner, int maxRetryAttempts) {
        int attemptsLeft = maxRetryAttempts;

        while (attemptsLeft > 0) {
            logAndPrint("Do you want to run the program again? (yes/no):");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                attemptsLeft--;

                if (attemptsLeft > 0)
                    logAndPrint("Invalid input. Please enter 'yes' or 'no', you have " + attemptsLeft + " attempts left.");
            }
        }

        logAndPrint("Sorry, I only asked for a yes or no. I can't take it anymore. :(");
        return false;
    }
}
