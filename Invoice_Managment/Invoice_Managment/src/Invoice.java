import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice extends Commercial_Document{
private ArrayList<Item> items;
private float tax_rate;

    public Invoice(int documentNumber,LocalDate dateIssued,Customer customerData,ArrayList<Item> items,float tax_rate){
        super(documentNumber, dateIssued, customerData);
        this.items = items;
        this.tax_rate = tax_rate;
    }

    //SPECIAL METHOD FOR OVERRIDING + method to add more items to invoice
    public float getInvoiceAmount(){//returns the total to a variable in main in order to be used
        float sum = 0;
        for(int i = 0;i < items.size();i++){
            sum += items.get(i).getItemAmount();
        }
        return sum;
    }
    @Override
    public void calculateTotal(){
        float total = 0;
        for(int i = 0;i < items.size();i++){
            total += items.get(i).getItemAmount();
        }
        total = total * tax_rate;

        System.out.println("Total Amount of invoice: " + total);
    }
}
