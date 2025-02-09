class CD extends Item {
    private String title;

    public CD(String serialNumber, String shelfNumber, int shelfIndex, String title) {
        super(serialNumber, shelfNumber, shelfIndex);
        this.title = title;
    }

    @Override
    public void displayDetails() {
        System.out.println("CD Title: " + title);
    }
}
