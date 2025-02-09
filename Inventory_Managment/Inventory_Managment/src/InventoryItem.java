public abstract class InventoryItem {
private int itemId;
private String itemName;
private float basePrice;

    public InventoryItem(int itemId,String itemName,float basePrice){
        this.itemId = itemId;
        this.itemName = itemName;
        this.basePrice = basePrice;
    }
    public int getItemId(){
        return itemId;
    }
    public String getItemName(){
        return itemName;
    }
    public float getBasePrice(){
        return basePrice;
    }
}
