public class Service extends InventoryItem{
//intaglible services
private int serviceDuration;

    public Service(int itemId,String itemName,float basePrice,int serviceDuration){
        super(itemId, itemName, basePrice);
        this.serviceDuration = serviceDuration;
    }
    public float calculatePrice(){
        return serviceDuration * getBasePrice();
    }
    public void displayServiceInformation(){
        System.out.println("Service information");
        System.out.println("Item ID: " + getItemId());
        System.out.println("Item Name: " + getItemName());
        System.out.println("Item base price: " + getBasePrice());
        System.out.println("Item's calculated total price: " + calculatePrice());
    }
}
