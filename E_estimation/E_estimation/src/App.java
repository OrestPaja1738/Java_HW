import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter max value for denominator:");
        int n = scanner.nextInt();

        // Use BigDecimal for precision
        BigDecimal valueOfE = BigDecimal.ZERO;

        BigDecimal factorial = BigDecimal.ONE; // To store factorial iteratively

        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                factorial = factorial.multiply(BigDecimal.valueOf(i)); // Iterative factorial
            }

            BigDecimal term = BigDecimal.ONE.divide(factorial, 20, RoundingMode.HALF_UP);

            valueOfE = valueOfE.add(term);
        }

        System.out.println("The approximate value of e: " + valueOfE);
    }
}

