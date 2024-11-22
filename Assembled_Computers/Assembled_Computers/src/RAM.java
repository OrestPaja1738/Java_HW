public class RAM {
    private int size;
    private String type;
    private String manufacturer;

    public RAM(int size,String type,String manufacturer){
        this.size = size;
        this.type = type;
        this.manufacturer = manufacturer;
    }
    public RAM(){
        this(0, "NULL", "NULL");
    }
    @Override
    public String toString() {
    return "RAM [Size=" + size + " GB, Type=" + type + ", Manufacturer=" + manufacturer + "]";
    }
}
