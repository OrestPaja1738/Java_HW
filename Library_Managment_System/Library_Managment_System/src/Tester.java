public class Tester {
    public static void main(String[] args) {
        Book book = new Book("B001", "S01", 1, "Java Programming", "XYZ Publisher", "John Doe");
        CD cd = new CD("C001", "S02", 2, "Learn Java");
        Magazine magazine = new Magazine("M001", "S03", 3, "Tech Magazine", "ABC Publisher");

        Student student = new Student("Alice", "Smith", "S1001");
        AcademicStaff staff = new AcademicStaff("Dr. Bob", "Johnson", "A2001");

        System.out.println(student.borrowItem(book) ? "Student borrowed the book." : "Student can't borrow this item.");
        System.out.println(student.borrowItem(magazine) ? "Student borrowed the magazine." : "Student can't borrow this item.");
        System.out.println(staff.borrowItem(book) ? "Staff borrowed the book." : "Staff can't borrow this item.");
        System.out.println(staff.borrowItem(cd) ? "Staff borrowed the CD." : "Staff can't borrow this item.");
    }
}