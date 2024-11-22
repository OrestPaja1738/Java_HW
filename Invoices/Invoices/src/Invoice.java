import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Invoice {

    private UUID ID;
    private LocalDate invoice_date;
    private LocalDate due_date;
    private Customer customer; 
    private Item item_list[];
    private double vat;
    private double calculated_discount;
    private double total_cost;
    

    public Invoice(){ //default empty constructor
        ID = UUID.randomUUID();
        invoice_date = LocalDate.now();
        due_date = invoice_date.plusDays(7);
        customer = new Customer();
        item_list = new Item[1];
        item_list[0] = new Item();
        vat = 0.0;
        calculated_discount = 0.0;
        total_cost = 0.0;
    }

    public Invoice(Customer object,int number_of_items,double discount_rate){

        Scanner scanner = new Scanner(System.in);

        ID = UUID.randomUUID();
        invoice_date = LocalDate.now();
        due_date = invoice_date.plusDays(7);
        customer = object;
        item_list = new Item[number_of_items];

        total_cost = 0;
            for(int i = 0; i < number_of_items; i++){
                int number,quantitySold;
                String name;
                double price;

                System.out.println("Enter number,name,price,quantity sold");
                number = scanner.nextInt();
                name = scanner.next();
                price = scanner.nextDouble();
                quantitySold = scanner.nextInt();
                
                item_list[i] = new Item(number, name, price, quantitySold);

                total_cost += item_list[i].getTotalPrice();
            }
        
        vat = total_cost * 0.2;
        calculated_discount = total_cost * discount_rate;
    }

    public UUID getID(){
        return ID;
    }
    public LocalDate getInvoiceDate(){
        return invoice_date;
    }
    public LocalDate getDueDate(){
        return  due_date;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Item[] getItemArray(){
        return item_list;
    }
    public double getVAT(){
        return vat;
    }
    public double getCalculatedDiscount(){
        return calculated_discount;
    }
    public double getTotalCost(){
        return total_cost;
    }


    //start of setter methods 
    public void setID(UUID ID){
        this.ID = ID;
    }
    public void setInvoiceDate(LocalDate invoice_date){
        this.invoice_date = invoice_date;
    }
    public void setDueDate(LocalDate due_date){
        this.due_date = due_date;
    }
    public void setCustomerClass(Customer customer){
        this.customer = customer;
    }
    public void setItemClass(Item[] item_list){
        this.item_list = item_list;
    }
    public void setVAT(double vat){
        this.vat = vat;
    }
    public void setCalculatedDiscount(double calculated_discount){
        this.calculated_discount = calculated_discount;
    }
    public void setTotalCost(double total_cost){
        this.total_cost = total_cost;
    }


    public void addItems(Item item){ //special setter
        if (item_list.length < 10) {
            Item temp[] = new Item[item_list.length + 1];
            
                for(int i = 0; i < item_list.length; i++){
                    temp[i] = item_list[i];
                }

            temp[item_list.length] = item;

            this.item_list = temp;
        }
        else{
            System.out.println("No more items are addable in the list!");
        }
    }

    public void calculateDiscount(){
        if (total_cost > 5000) {
            calculated_discount = total_cost * 0.10;
            total_cost -= calculated_discount;
        }
        else{
            calculated_discount = 0.0;
        }
    }

    @Override

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Invoice ID: %s\nInvoice Date: %s\nDue Date: %s\n",getID(), getInvoiceDate(), getDueDate()));
        sb.append(String.format("Customer Name: %s\nEmail: %s\nAddress: %s\n",customer.getName(), customer.getEmail(), customer.getAddress()));

        sb.append("Items:\n");
        for (Item item : item_list) {
            sb.append(String.format("  %s - %d units @ %.2f each\n", item.getName(), item.getQuantitySold(), item.getPrice()));
        }

        sb.append(String.format("\nTotal Cost: %.2f\nVAT: %.2f\nDiscount: %.2f\nTotal After Discount: %.2f",total_cost, vat, calculated_discount, total_cost - calculated_discount));

        return sb.toString();
    }
}