import java.time.LocalDate;

public abstract class Commercial_Document {
private int documentNumber;
private LocalDate dateIssued;
private Customer customerData;

    public Commercial_Document(int documentNumber,LocalDate dateIssued,Customer customerData){
        this.documentNumber = documentNumber;
        this.dateIssued = dateIssued;
        this.customerData = customerData;
    }

    abstract void calculateTotal();

    public int getDocumentNumber(){
        return documentNumber;
    }
    public LocalDate getDateIssued(){
        return dateIssued;
    }
}
