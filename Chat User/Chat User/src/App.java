public class App {
    public static void main(String[] args) throws Exception {
        ChatUser u1 = new ChatUser("Jonathan", 31);
        ChatUser u2 = new ChatUser();
        ChatUser u3 = new ChatUser("Antonnete", 24, "France");
        ChatUser u4 = new ChatUser(36);

        u1.setLocation("Canada");
        u2.setLocation("Japan");
        u1.printStatus();
        u2.printStatus();
        u3.printStatus();
        u4.printStatus();
    }
}
