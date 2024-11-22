import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Creating an Invoice
        Scanner scanner = new Scanner(System.in);

        String name,email,address;
        System.out.println("Enter the customer information! name,email,address");
        name = scanner.next();
        email = scanner.next();
        address = scanner.next();
        
        Customer customer = new Customer(name, email, address);

        int number_of_items;
        double discount_rate;
        System.out.println("Enter number of items and discount rate!");
        number_of_items = scanner.nextInt();
        discount_rate = scanner.nextDouble();

        Invoice invoice = new Invoice(customer, number_of_items, discount_rate);

        System.out.println(invoice.toString());
    }
}
