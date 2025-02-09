import java.time.LocalDate;
import java.util.Scanner;

public class Proforma extends Commercial_Document{
private LocalDate validityDate;

    public Proforma(int documentNumber,LocalDate dateIssued,Customer customerData,LocalDate validityDate){
        super(documentNumber, dateIssued, customerData);
        int amount_of_days;
        System.out.println("Enter amount of days of validity!");
        Scanner scanner = new Scanner(System.in);
        amount_of_days = scanner.nextInt();
        this.validityDate = validityDate.plusDays(amount_of_days);
    }
    //method for overriding
    @Override
    public void calculateTotal(){
        System.out.println("Validity date until :" + validityDate);
    }
}
