class Book extends Item {
    private String name;
    private String publisher;
    private String author;

    public Book(String serialNumber, String shelfNumber, int shelfIndex, String name, String publisher, String author) {
        super(serialNumber, shelfNumber, shelfIndex);
        this.name = name;
        this.publisher = publisher;
        this.author = author;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book Name: " + name + ", Publisher: " + publisher + ", Author: " + author);
    }
}
