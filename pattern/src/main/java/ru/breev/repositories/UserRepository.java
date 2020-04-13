package ru.breev.repositories;

import ru.breev.entities.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository{
    private List<User> users;
    private User user;
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @PostConstruct
    public void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        users = new ArrayList<>();
    }

    public List<User> findAll() throws SQLException {
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM user");
        while (rs.next()) {
            users.add(new User(rs.getInt("id"), rs.getString("login"),
                    rs.getString("password"), rs.getString("name")));
        }
        return users;
    }

    public User findById(Integer id) throws SQLException {
        pstmt = conn.prepareStatement("SELECT * FROM user WHERE id = ?");
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            user = new User(rs.getInt("id"), rs.getString("login"),
                    rs.getString("password"), rs.getString("name"));
        }
        return user;
    }
}