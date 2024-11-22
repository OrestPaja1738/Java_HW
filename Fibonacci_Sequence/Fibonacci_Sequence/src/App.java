import java.util.Scanner;

public class App {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int lowerLimit = (int) Math.pow(10, n - 1);  
        int upperLimit = (int) Math.pow(10, n); 
        System.out.println("The Fibonacci sequence terms with " + n + " digits are:");

        long a = 1, b = 1;

            while (b < upperLimit) {
                if (b >= lowerLimit) {
                System.out.println(b);
                }
                long temp = b;
                b = a + b;  
                a = temp;
            }
    }
}
