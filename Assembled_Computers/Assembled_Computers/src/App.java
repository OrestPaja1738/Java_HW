import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        CPU cpu = getCpuData(scanner);
        RAM ram = getRamData(scanner);
        HDD hard_disk = get_HDD_data(scanner);
        Motherboard motherboard = getMotherboardData(scanner);
        int assembly_year;
        float price;

        System.out.println("Enter assembly year!");
        while (true) { 
            assembly_year = scanner.nextInt();
            if (assembly_year > 0) {
                break;
            }
            else{
                System.out.println("Enter valid year of assembly");
            }
        }

        System.out.println("Enter price!");
        while (true) { 
            price = scanner.nextFloat();
            if (price > 0) {
                break;
            }
            else{
                System.out.println("Enter a valid value for price!");
            }
        }
        
        Computer test = new Computer(cpu, ram, hard_disk, motherboard, assembly_year, price);

        System.out.println("\nComputer Information:");
        System.out.println(test);
    }

    public static CPU getCpuData(Scanner scanner){
        
        System.err.println("Enter CPU attributes!");
        int clock_frequency;
        String instruction_set;
        int type;
        int number_of_registers;
        String manufacturer;

        System.out.println("Enter clock frequency!");
        while (true) { 
            clock_frequency = scanner.nextInt();
            if (clock_frequency > 0) {
                break;
            }
            else{
                System.out.println("The value is invalid,reenter again!");
            }
        }
        System.out.println("Enter instruction set architecture!");
        while (true) { 
            instruction_set = scanner.next();
            if (instruction_set.equalsIgnoreCase("RISC") || instruction_set.equalsIgnoreCase("CISC")){
                break;
            }
            else{
                System.out.println("Enter again for type CISC or RISC!");
            }
        }
        System.out.println("Enter cpu type!");
        while (true) { 
            type = scanner.nextInt();
            if (type == 32 || type == 64) {
                break;
            }
            else{
                System.out.println("Enter again for a valid type of processor (32 or 64bit)!");
            }
        }
        System.out.println("Enter number of registers!");
        while (true) { 
            number_of_registers = scanner.nextInt();
            if (number_of_registers == 16 || number_of_registers == 32) {
                break;
            }
            else{
                System.out.println("Enter again for a valid number of registers (32 or 16)!");
            }
        }
        System.out.println("Enter manufacturer!");
        manufacturer = scanner.next();

        CPU fnOutput = new CPU(clock_frequency, instruction_set, type, number_of_registers, manufacturer);

        return fnOutput;
    }

    public static RAM getRamData(Scanner scanner){
    
        System.out.println("\nEnter RAM attributes!");
        int size;
        String type;
        String manufacturer;

        System.out.println("Enter RAM size!");
        while (true) { 
            size = scanner.nextInt();
            if (size > 0) {
                break;
            }
            else{
                System.out.println("Enter a valid input!");
            }
        }
        System.out.println("Enter RAM type!");
        while (true) {
            type = scanner.next();
            if (type.equalsIgnoreCase("DDR") || type.equalsIgnoreCase("DDR2") || type.equalsIgnoreCase("DDR3")){
                break;
            }
            else{
                System.out.println("Enter a valid RAM type!");
            }
        }
        System.out.println("Enter manufacturer!");
        manufacturer = scanner.next();

        RAM fnOutput = new RAM(size, type, manufacturer);

        return fnOutput;
    }

    public static HDD get_HDD_data(Scanner scanner){
        
        System.out.println("\nEnter HDD attributes");
        int size;
        int rotations;
        String manufacturer;

        System.out.println("Enter HDD size!");
        while (true) {
            size = scanner.nextInt();
            if (size > 0) {
                break;
            }
            else{
                System.out.println("Enter a valid input for HDD size!");
            }
        }
        System.out.println("Enter HDD rotations!");
        while (true) {
            rotations = scanner.nextInt();
            if (size > 0) {
                break;
            }
            else{
                System.out.println("Enter a valid input for HDD rotations!");
            }
        }
        System.out.println("Enter manufacturer!");
        manufacturer = scanner.next();

        HDD fnOutput = new HDD(size, rotations, manufacturer);

            return fnOutput;
    }

    public static Motherboard getMotherboardData(Scanner scanner){
        
        System.out.println("\nEnter Motherboard attributes!");
        String chipset_version;
        int usb_ports;
        int ram_capacity;
        String manufacturer;
        
        System.out.println("Enter chipset version");
        chipset_version = scanner.next();

        System.out.println("Enter number of usb ports!");
        while (true) { 
            usb_ports = scanner.nextInt();
            if (usb_ports > 0) {
                break;
            }
            else{
                System.out.println("Enter a valid amount of usb ports!");
            }
        }
        System.out.println("Enter value for RAM capacity for motherboard!");
        while (true) { 
            ram_capacity = scanner.nextInt();
            if (ram_capacity > 0) {
                break;
            }
            else{
                System.out.println("Enter a valid amount of Ram capacity!");
            }
        }
        System.out.println("Enter manufacturer");
        manufacturer = scanner.next();

        Motherboard fnOutput = new Motherboard(chipset_version, usb_ports, ram_capacity, manufacturer);
        
            return  fnOutput;
    }
}
