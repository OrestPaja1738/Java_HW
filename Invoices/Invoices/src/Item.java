public class Item {
    private int number;//item id
    private String name;
    private double price;
    private int quantitySold;

    public Item(int number,String name,double price,int quantitySold){
        this.number = number;
        this.name = name;
        this.price = price;
        this.quantitySold = quantitySold;
    }

    public Item(){
        this(0, "name", 0, 0);
    }

    public String getName(){
        return name;
    }
    public int getQuantitySold(){
        return quantitySold;
    }
    public double getPrice(){
        return price;
    }

    public double getTotalPrice(){
        return (price * quantitySold);
    }
}
