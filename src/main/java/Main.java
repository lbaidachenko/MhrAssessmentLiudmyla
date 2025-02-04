import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            System.out.println("Please enter your date of birth in format YYYY/MM/DD:");
            Scanner scanner = new Scanner(System.in);

            LocalDate dateOfBirth = DateUtils.inputDateOfBirthOrRetry(scanner, 3);
            if (dateOfBirth == null) {
                System.out.println("Too many invalid attempts. Please try again later.");
                return;
            }

            DateUtils.validateAge(dateOfBirth);
    }
}
