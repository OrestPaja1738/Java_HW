public class ChatUser {
    
    private String nickname;
    private int age;
    private String location;

    private static int user_counter = 1;

    public ChatUser(){
        this.nickname = "Anonymous " + user_counter;
        this.age = 20;
        this.location = "U.S.A";
        user_counter++;
        System.out.println("User " + nickname + " age: " + age + " location: " + location + " joined the chat");
    }
    public ChatUser(int age){
        this.nickname = "Anonymous " + user_counter;
        this.age = age;
        this.location = "U.S.A";
        user_counter++;
        System.out.println("User " + nickname + " age: " + age + " location: " + location + " joined the chat");
    }
    public ChatUser(String nickname,int age){
        this.nickname = nickname;
        this.age = age;
        this.location = "U.S.A";
        System.out.println("User " + nickname + " age: " + age + " location: " + location + " joined the chat");
    }
    public ChatUser(String nickname,int age,String location){
        this.nickname = nickname;
        this.age = age;
        this.location = location;
        System.out.println("User " + nickname + " age: " + age + " location: " + location + " joined the chat");
    }

    public String getNickname(){
        return nickname;
    }
    public int getAge(){
        return age;
    }
    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void printStatus(){
        System.out.println("User " + nickname + " age: " + age + " location: " + location + " is in the chat");
    }
}
