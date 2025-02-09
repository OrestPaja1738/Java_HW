class Magazine extends Item {
    private String name;
    private String publisher;

    public Magazine(String serialNumber, String shelfNumber, int shelfIndex, String name, String publisher) {
        super(serialNumber, shelfNumber, shelfIndex);
        this.name = name;
        this.publisher = publisher;
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine Name: " + name + ", Publisher: " + publisher);
    }
}