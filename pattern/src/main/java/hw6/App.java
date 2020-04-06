package hw6;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        UserMapper um = new UserMapper(DB.connect());

        User user = um.findById(1);

        System.out.println(user);
    }
}
