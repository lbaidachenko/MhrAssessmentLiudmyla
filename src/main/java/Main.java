import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please enter your date of birth in format YYYY/MM/DD:");
            LocalDate dateOfBirth = DateUtils.inputDateOfBirthOrRetry(scanner, 3);

            if (dateOfBirth != null)
                DateUtils.validateAge(dateOfBirth);

        } while (DateUtils.wantToRestart(scanner, 3));
    }
}
