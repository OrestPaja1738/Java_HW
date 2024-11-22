public class CPU {
    private int clock_frequency;
    private String instruction_set;
    private int type;
    private int number_of_registers;
    private String manufacturer;

    public CPU(int clock_frequency,String instruction_set,int type,int number_of_registers,String manufacturer){
        this.clock_frequency = clock_frequency;
        this.instruction_set = instruction_set;
        this.type = type;
        this.number_of_registers = number_of_registers;
        this.manufacturer = manufacturer;
    }
    public CPU(){
        this(0, "NULL", 0, 0, "NULL");
    }
    @Override
    public String toString() {
    return "CPU [Clock Frequency=" + clock_frequency + " MHz, Instruction Set=" + instruction_set + 
           ", Type=" + type + "-bit, Registers=" + number_of_registers + ", Manufacturer=" + manufacturer + "]";
    }   
}
