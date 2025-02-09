import java.time.LocalDate;

public class Credit_Note extends Commercial_Document{
private int invoiceNumber;
private float refundedAmount;

    public Credit_Note(int documentNumber,LocalDate dateIssued,Customer customerData,int invoiceNumber,float refundedAmount){
        super(documentNumber, dateIssued, customerData);
        this.invoiceNumber = invoiceNumber;
        this.refundedAmount = refundedAmount;
    }
    //method for overriding start
    @Override
    public void calculateTotal(){
        System.out.println("CREDIT AMOUNT :" + refundedAmount);
    }
}
