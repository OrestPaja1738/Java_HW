class Student extends Person {
    private Item borrowedItem;

    public Student(String name, String surname, String uniqueNumber) {
        super(name, surname, uniqueNumber);
    }

    @Override
    public boolean borrowItem(Item item) {
        if (item instanceof Book || item instanceof CD) {
            borrowedItem = item;
            return true;
        }
        return false;
    }
}
