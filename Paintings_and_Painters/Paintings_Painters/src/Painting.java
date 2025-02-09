public class Painting {
private String title;
private int length;
private int width;
private double price;
private boolean sold;

    public Painting(String title,int length,int width,double price,boolean sold){
        this.title = title;
        this.length = length;
        this.width = width;
        this.price = price;
        this.sold = sold;
    }

    public String getTitle(){
        return  title;
    }
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
    public double getPrice(){
        return price;
    }
    public boolean isSold(){
        return sold;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public void setSoldStatus(boolean sold){
        this.sold  = sold;
    }

    @Override
    public String toString(){
        return "Name of painting: " + this.title + "\nLength of painting :"
         + this.length + "\nWidth of the painting: " + this.width + 
         "\nPrice of the painting: " + this.price + "\nSold status: " + this.sold;
    }
}
