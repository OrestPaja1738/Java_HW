public class Digital_Asset extends InventoryItem{
private float fileSize;

    public Digital_Asset(int itemId,String itemName,float basePrice,float fileSize){
        super(itemId, itemName, basePrice);
        this.fileSize = fileSize;
    }
    public float calculatePrice(){
        return fileSize * getBasePrice();
    }
    public void displayDigitalAssetInformation(){
        System.out.println("Digital Asset information");
        System.out.println("Item ID: " + getItemId());
        System.out.println("Item Name: " + getItemName());
        System.out.println("Item base price: " + getBasePrice());
        System.out.println("Item's calculated total price: " + calculatePrice());
    }
}
