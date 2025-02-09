class AcademicStaff extends Person {
    private Item[] borrowedItems = new Item[3];
    private int itemCount = 0;

    public AcademicStaff(String name, String surname, String uniqueNumber) {
        super(name, surname, uniqueNumber);
    }

    @Override
    public boolean borrowItem(Item item) {
        if (itemCount < 3 && (item instanceof Book || item instanceof CD)) {
            borrowedItems[itemCount++] = item;
            return true;
        }
        return false;
    }
}
