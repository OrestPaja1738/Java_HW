public class Item {
private int code;
private String description;
private float price_per_unit;
private int quantity;

    public Item(int code,String description,float price_per_unit,int quantity){
        this.code = code;
        this.description = description;
        this.price_per_unit = price_per_unit;
        this.quantity = quantity;
    }

    public int getItemCode(){
        return code;
    }
    public float getItemAmount(){
        return price_per_unit * quantity;
    }
}
