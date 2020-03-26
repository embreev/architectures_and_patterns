package hw3;

public class App {
    public static void main(String[] args) {
        User admin = new UserBuilder().name("Administrator").login("admin").password("admin123").role("ADMIN").create();
        System.out.println(admin);
    }
}
