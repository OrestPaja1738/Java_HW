abstract class Person {
    protected String name;
    protected String surname;
    protected String uniqueNumber;

    public Person(String name, String surname, String uniqueNumber) {
        this.name = name;
        this.surname = surname;
        this.uniqueNumber = uniqueNumber;
    }

    public abstract boolean borrowItem(Item item);
}
