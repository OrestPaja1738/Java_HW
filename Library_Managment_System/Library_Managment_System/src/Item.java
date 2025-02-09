abstract class Item {
    protected String serialNumber;
    protected String shelfNumber;
    protected int shelfIndex;

    public Item(String serialNumber, String shelfNumber, int shelfIndex) {
        this.serialNumber = serialNumber;
        this.shelfNumber = shelfNumber;
        this.shelfIndex = shelfIndex;
    }

    public abstract void displayDetails();
}
