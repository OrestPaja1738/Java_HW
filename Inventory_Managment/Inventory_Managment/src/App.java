import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Start of item menu!");
        //user has an inventory of products,services and digital assets
        ArrayList<InventoryItem> userInventory = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        //menu below
        while (true) { 
            System.out.println("Menu options as follows : 1. for adding into inventory 2.removing from inventory 3.utilizing special functions 0. exiting menu");
            System.out.println("Enter menu option!");
            int menuOption;
            menuOption = scanner.nextInt();

            if (menuOption == 1) {//adding items in inventory
                System.out.println("Select 1. for adding a Product,2. for adding a Service and 3. for adding a Digital Asset");
                int menuX;
                menuX = scanner.nextInt();

                switch (menuX) {
                    case 1:
                        Product p = createProduct(scanner);
                        userInventory.add(p);
                        break;
                    case 2:
                        Service s = createService(scanner);
                        userInventory.add(s);
                        break;
                    case 3:
                        Digital_Asset d = createDigitalAsset(scanner);
                        userInventory.add(d);
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            else if(menuOption == 2){//removing items from inventory
                System.out.println("Enter id of the item inside inventory that you want to remove");
                int key = scanner.nextInt();
                if (userInventory.isEmpty()) {
                    System.out.println("There are no items that can be deleted!");
                    break;
                }
                else{
                    boolean status = false;
                    for(int i = 0;i < userInventory.size();i++){
                        if (userInventory.get(i).getItemId() == key) {
                            System.out.println("Item found,proceding to delete");
                            userInventory.remove(i);
                            status = true;
                            break;
                        }
                    }
                    if (!status) {
                        System.out.println("Item not found after search.Try again");
                        break;
                    }
                }
            }
            else if(menuOption == 3){//special functions 
                if (userInventory.isEmpty()) {
                    System.out.println("No functions can be implemented as inventory is empty");
                    break;
                }
                else{
                System.out.println("Enter 1 for calculated total of item and 2 for display options or 3 to utilize product functions");
                int menuY;
                menuY = scanner.nextInt();
                switch (menuY) { //menu for either calculating totals or displaying information
                    case 1://calculating total
                        System.out.println("Enter id for the item you want to get calculated total");
                        int key = scanner.nextInt();

                        System.out.println("Enter 1 to get calculated total of Product 2 for Digital Asset 3 for Service");
                        int x = scanner.nextInt();
                        if (x == 1) {//finding Product
                            boolean status = false;
                            for(int i = 0;i < userInventory.size();i++){
                                if (userInventory.get(i) instanceof Product && userInventory.get(i).getItemId() == key) {
                                    Product p = (Product)userInventory.get(i);
                                    System.out.println("Output: " + p.calculatePrice());
                                    status = true;
                                    break;
                                }
                            }
                            if (!status) {
                                System.out.println("Cannot get calculated total for Product as the id is invalid");
                                break;
                            }
                        }
                        else if(x == 2){//finding digital asset
                            boolean status = false;
                            for(int i = 0;i < userInventory.size();i++){
                                if (userInventory.get(i) instanceof Digital_Asset && userInventory.get(i).getItemId() == key) {
                                    Digital_Asset d = (Digital_Asset)userInventory.get(i);
                                    System.out.println("Output: " + d.calculatePrice());
                                    status = true;
                                    break;
                                }
                            }
                            if (!status) {
                                System.out.println("Cannot get calculated total for Digital Asset as the id is invalid");
                                break;
                            }
                        }
                        else if(x == 3){//finding service
                            boolean status = false;
                            for(int i = 0;i < userInventory.size();i++){
                                if (userInventory.get(i) instanceof Service && userInventory.get(i).getItemId() == key) {
                                    Service s = (Service)userInventory.get(i);
                                    System.out.println("Output: " + s.calculatePrice());
                                    status = true;
                                }
                            }
                            if (!status) {
                                System.out.println("Cannot get calculated total for Service as the id is invalid");
                                break;
                            }
                        }
                        break;
                    case 2://displaying information
                    if (userInventory.isEmpty()) {
                        System.out.println("No information can be displayed as user inventory is empty");
                    }
                    else{
                        System.out.println("Enter 1 to display Product information,2 to display Digital Asset information or 3 to display Service information");
                        int menuZ = scanner.nextInt();
                        if (menuZ == 1) {
                            System.out.println("Enter id of Product");
                            key = scanner.nextInt();
                            boolean status = false;
                            for(int i = 0;i < userInventory.size();i++){
                                if (userInventory.get(i) instanceof Product && userInventory.get(i).getItemId() == key) {
                                    Product p = (Product)userInventory.get(i);
                                    p.displayDetails();
                                    status = true;
                                    break;
                                }
                            }
                            if (!status) {
                                System.out.println("Cannot display details as product is not found!");
                                break;
                            }
                        }
                        else if(menuZ == 2){
                            System.out.println("Enter id of Digital Asset");
                            key = scanner.nextInt();
                            boolean status = false;
                            for(int i = 0;i < userInventory.size();i++){
                                if (userInventory.get(i) instanceof Digital_Asset && userInventory.get(i).getItemId() == key) {
                                    Digital_Asset d = (Digital_Asset)userInventory.get(i);
                                    d.displayDigitalAssetInformation();
                                    status = true;
                                    break;
                                }
                            }
                            if (!status) {
                                System.out.println("Cannot display details as digital asset is not found!");
                                break;
                            }
                        }
                        else if(menuZ == 3){
                            System.out.println("Enter id of Service");
                            key = scanner.nextInt();
                            boolean status = false;
                            for(int i = 0;i < userInventory.size();i++){
                                if (userInventory.get(i) instanceof Service && userInventory.get(i).getItemId() == key) {
                                    Service s = (Service)userInventory.get(i);
                                    s.displayServiceInformation();;
                                    status = true;
                                    break;
                                }
                            }
                            if (!status) {
                                System.out.println("Cannot display details as service is not found!");
                                break;
                            }
                        }
                        else{
                            System.out.println("Invalid Menu option try again");
                            break;
                        } 
                    }
                        break;
                    case 3://special functions of product (STOCK AND RESTOCK)
                    if (userInventory.isEmpty()) {
                        System.out.println("Inventory is empty,no special functions can be used!");
                        break;
                    }
                    else{
                        System.out.println("Enter 1 for getting the stock level of a certain item or 2 for restocking an item");
                        int menuJ = scanner.nextInt();
                        if (menuJ == 1) {
                            System.out.println("Enter id of product in order to get stock level");
                            key = scanner.nextInt();
                            boolean status = false;
                            for(int i = 0;i < userInventory.size();i++){
                                if (userInventory.get(i) instanceof Product && userInventory.get(i).getItemId() == key) {
                                    Product p = (Product)userInventory.get(i);
                                    System.out.println("Stock level of product with id: " + key + " is " + p.getStockLevel());
                                    status = true;
                                    break;
                                }
                            }
                            if (!status) {
                                System.out.println("Cannot get stock levels of product as it's not found in the inventory");
                                break;
                            }
                        }
                        //condition for restocking
                        else if (menuJ == 2) {
                            System.out.println("Enter id of product in order to get restock");
                            key = scanner.nextInt();
                            System.out.println("Enter amount in order for restocking");
                            int amount = scanner.nextInt();
                            boolean status = false;

                            for(int i = 0;i < userInventory.size();i++){
                                if (userInventory.get(i) instanceof Product && userInventory.get(i).getItemId() == key) {
                                    Product p = (Product)userInventory.get(i);
                                    p.restock(amount);
                                    userInventory.remove(i); //remove the old item and replace with new one
                                    userInventory.add(p);
                                    status = true;
                                    System.out.println("Restocking succesful!");
                                    break;
                                }
                            }
                            if (!status) {
                                System.out.println("Cannot restock product as it is not found!");
                                break;
                            }
                        }
                        else{
                            System.out.println("Invalid menu option!");
                            break;
                        }
                    }
                        break;
                    default:
                        System.out.println("Wrong input");
                        break;
                }
                }
            }
            else if(menuOption == 0){
                System.out.println("Exiting menu . . .");
                break;
            }
            else{
                System.out.println("Incorrect input.Try again");
            }
        }

    }
    public static Product createProduct(Scanner scanner){
        System.out.println("Enter PRODUCT creation details below");
        int itemId,stockLevel;
        String itemName;
        float basePrice;

        System.out.println("Enter item ID:");
        itemId = scanner.nextInt();
        System.out.println("Enter item name:");
        itemName = scanner.next();
        System.out.println("Enter base price");
        basePrice = scanner.nextFloat();
            while (true) { 
                if (basePrice < 0) {
                    System.out.println("Incorrect value try inputting base price again");
                    basePrice = scanner.nextFloat();
                }
                else{
                    break;
                }
            }
        System.out.println("Enter stock level of product");
        stockLevel = scanner.nextInt();
        while (true) { 
            if (stockLevel <= 1) {
                System.out.println("Incorrect value try inputting stock level again");
                stockLevel = scanner.nextInt();
            }
            else{
                break;
            }
        }

        Product p = new Product(itemId, itemName, basePrice, stockLevel);

        return p;
    }
    public static Service createService(Scanner scanner){
        System.out.println("Enter Service creation details below");
        int itemId,serviceDuration;
        String itemName;
        float basePrice;

        System.out.println("Enter item ID:");
        itemId = scanner.nextInt();
        System.out.println("Enter item name:");
        itemName = scanner.next();
        System.out.println("Enter base price");
        basePrice = scanner.nextFloat();
        while (true) { 
            if (basePrice < 0) {
                System.out.println("Incorrect value try inputting base price again");
                basePrice = scanner.nextFloat();
            }
            else{
                break;
            }
        }
        System.out.println("Enter service duration of service");
        serviceDuration = scanner.nextInt();
        while (true) { 
            if (serviceDuration <= 1) {
                System.out.println("Incorrect value try inputting stock level again");
                serviceDuration = scanner.nextInt();
            }
            else{
                break;
            }
        }

        Service s = new Service(itemId, itemName, basePrice, serviceDuration);

        return s;
    }
    public static Digital_Asset createDigitalAsset(Scanner scanner){
        System.out.println("Enter Digital Asset creation details below");
        int itemId;
        String itemName;
        float basePrice,fileSize;

        System.out.println("Enter item ID:");
        itemId = scanner.nextInt();
        System.out.println("Enter item name:");
        itemName = scanner.next();
        System.out.println("Enter base price");
        basePrice = scanner.nextFloat();

        while (true) { 
            if (basePrice < 0) {
                System.out.println("Incorrect value try inputting base price again");
                basePrice = scanner.nextFloat();
            }
            else{
                break;
            }
        }
        System.out.println("Enter file size of Digital Asset");
        fileSize = scanner.nextFloat();
        while (true) { 
            if (fileSize <= 0) {
                System.out.println("Incorrect value try inputting stock level again");
                fileSize = scanner.nextFloat();
            }
            else{
                break;
            }
        }
        
        Digital_Asset d = new Digital_Asset(itemId, itemName, basePrice, fileSize);

        return d;
    }
}
