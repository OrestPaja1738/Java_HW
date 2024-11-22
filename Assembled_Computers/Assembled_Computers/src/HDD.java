public class HDD {
    private int size;
    private int rotations;
    private String manufacturer;

    public HDD(int size,int rotations,String manufacturer){
        this.size = size;
        this.rotations = rotations;
        this.manufacturer = manufacturer;
    }
    public HDD(){
        this(0, 0, "NULL");
    }
    @Override
    public String toString() {
    return "HDD [Size=" + size + " GB, Rotations=" + rotations + " RPM, Manufacturer=" + manufacturer + "]";
    }
}
