public class Motherboard {
    private String chipset_version;
    private int usb_ports;
    private int ram_capacity;
    private String manufacturer;

    public Motherboard(String chipset_version,int usb_ports,int ram_capacity,String manufacturer){
        this.chipset_version = chipset_version;
        this.usb_ports = usb_ports;
        this.ram_capacity = ram_capacity;
        this.manufacturer = manufacturer;    
    }
    public Motherboard(){
        this("NULL", 0, 0, "NULL");
    }
    @Override
    public String toString() {
    return "Motherboard [Chipset Version=" + chipset_version + ", USB Ports=" + usb_ports + 
           ", RAM Capacity=" + ram_capacity + " GB, Manufacturer=" + manufacturer + "]";
    }
}
