package hw6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static String CON_STR = "jdbc:sqlite:ast.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(CON_STR);
    }
}
