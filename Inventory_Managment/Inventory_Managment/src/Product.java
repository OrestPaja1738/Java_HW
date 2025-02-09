public class Product extends InventoryItem implements Sellable,Trackable{
//represents tangible items in inventory
private int stockLevel;

    public Product(int itemId,String itemName,float basePrice,int stockLevel){
        super(itemId, itemName, basePrice);
        this.stockLevel = stockLevel;
    }
    @Override
    public float calculatePrice(){
        return stockLevel * getBasePrice();
    }
    @Override
    public void displayDetails(){
        System.out.println("Product information");
        System.out.println("Item ID: " + getItemId());
        System.out.println("Item Name: " + getItemName());
        System.out.println("Item base price: " + getBasePrice());
        System.out.println("Item stock level: " + stockLevel);
        System.out.println("Item's calculated total price: " + calculatePrice());
    }
    @Override
    public int getStockLevel(){
        return stockLevel;
    }
    @Override
    public void restock(int amount){
        if (amount < 1) {
            System.err.println("invalid amount for restocking");
        }
        else{
            this.stockLevel += amount;
        }
    }
}
