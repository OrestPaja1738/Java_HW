import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("COMMERCIAL DOCUMENT MENU START");
        Customer customer = getCustomerDetails();
        ArrayList<Item>customer_items = new ArrayList<>();

        int item_menu_option;
        Scanner scanner = new Scanner(System.in);
        
        while (true) { 
            System.out.println("Enter 1 to add item / enter 2 to remove item from item list /0 to exit menu");
            item_menu_option = scanner.nextInt();
            if (item_menu_option == 1) { //add item
                Item tempItem = getItemDetails();
                customer_items.add(tempItem);
            }
            else if (item_menu_option == 2) { //remove item
                System.out.println("Enter code in order to find the item to remove it");
                int code_for_search;
                boolean status = false;
                code_for_search = scanner.nextInt();
                for(int i = 0;i < customer_items.size();i++){
                    if (customer_items.get(i).getItemCode() == code_for_search) {
                        System.out.println("Item found!,proceding to delete");
                        status = true;
                        customer_items.remove(i);
                        break;
                    }
                }
                if (!status) {
                    System.out.println("Item not found in the list thus not deleted");
                }
            }
            else if(item_menu_option == 0){
                System.out.println("Exiting menu!");
                break;
            }
            else{
                System.out.println("Incorrect menu option enter again!");
            }
        }

        //end of item menu
        //creating invoice
        Invoice invoice = createInvoice(customer,customer_items);
        Credit_Note creditNote = createCreditNote(customer,invoice);
        Proforma proforma = createProforma(customer,invoice);
        //ending of document creation

        invoice.calculateTotal();
        creditNote.calculateTotal();
        proforma.calculateTotal();
    }

    public static Customer getCustomerDetails(){
        Scanner scanner = new Scanner(System.in);
        String fnName,fnSurname,fnPhone,fnAddress;
        System.out.println("Enter customer information of name,surname,phone nr and address:");
        fnName = scanner.next();
        fnSurname = scanner.next();
        fnPhone = scanner.next();
        fnAddress = scanner.next();

        Customer fnCustomer = new Customer(fnName, fnSurname, fnPhone, fnAddress);

        return fnCustomer;
    }
    public static Item getItemDetails(){
        Scanner scanner = new Scanner(System.in);
        int fnCode,fnQuantity;
        String fnDescription;
        float fnPrice;
        System.out.println("Enter item information about code,description,price per unit,quantity");
        fnCode = scanner.nextInt();
        fnDescription = scanner.next();
        fnPrice = scanner.nextFloat();
        fnQuantity = scanner.nextInt();

        Item fnItem = new Item(fnCode, fnDescription, fnPrice, fnQuantity);

        return fnItem;
    }
    public static Invoice createInvoice(Customer customer,ArrayList<Item>customer_items){
        System.out.println("Start of invoice creation");
        int documentNumber;
        LocalDate dateIssued;
        System.out.println("Enter document number!");
        Scanner scanner = new Scanner(System.in);
        documentNumber = scanner.nextInt();
        dateIssued = LocalDate.now();
        System.out.println("Enter tax rate for the invoice!");
        float taxRate;
        taxRate = scanner.nextFloat();

        Invoice invoice = new Invoice(documentNumber, dateIssued, customer, customer_items, taxRate);

        return invoice;
    }
    public static Credit_Note createCreditNote(Customer customer,Invoice invoice){
        System.out.println("Start of Credit Note creation!");
        int documentNumber;
        LocalDate dateIssued;
        System.out.println("Enter document number!");
        Scanner scanner = new Scanner(System.in);
        documentNumber = scanner.nextInt();
        dateIssued = LocalDate.now();
        int invoiceNumber = invoice.getDocumentNumber();//set invoices document number for credit note variable
        float refundedAmount;
        System.out.println("Enter refunded Amount!");
        refundedAmount = scanner.nextFloat();

        Credit_Note creditNote = new Credit_Note(documentNumber, dateIssued, customer, invoiceNumber, refundedAmount);

        return  creditNote;
    }
    public static Proforma createProforma(Customer customer,Invoice invoice){
        System.out.println("Start of Proforma creation!");
        int documentNumber;
        LocalDate dateIssued;
        System.out.println("Enter document number!");
        Scanner scanner = new Scanner(System.in);
        documentNumber = scanner.nextInt();
        dateIssued = LocalDate.now();
        LocalDate validDate;
        validDate = invoice.getDateIssued();
        
        Proforma proforma = new Proforma(documentNumber, dateIssued, customer, validDate);

        return proforma;
    }
}
