public class Computer {
    private CPU cpu;
    private RAM ram;
    private HDD hard_disk;
    private Motherboard motherboard;
    private int assembly_year;
    private float price;

    public Computer(CPU cpu,RAM ram,HDD hard_disk,Motherboard motherboard,int assembly_year,float price){
        this.cpu = cpu;
        this.ram = ram;
        this.hard_disk = hard_disk;
        this.motherboard = motherboard;
        this.assembly_year = assembly_year;
        this.price = price;    
    }

    @Override
    public String toString() {
    return "Computer Details:\n" +
           "=====================\n" +
           "CPU: " + cpu + "\n" +
           "RAM: " + ram + "\n" +
           "HDD: " + hard_disk + "\n" +
           "Motherboard: " + motherboard + "\n" +
           "Assembly Year: " + assembly_year + "\n" +
           "Price: $" + price;
    }
}
