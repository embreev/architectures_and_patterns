package hw6;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserMapper {
    private Connection connection;
    private Map<Integer, User> userMap;

    public UserMapper(Connection connection) {
        this.connection  = connection;
        userMap = new HashMap<Integer, User>();
    }

    public User findById(int idUser) throws SQLException {
        if (userMap.containsKey(idUser)) {
            return userMap.get(idUser);
        }
        User user = new User();
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idUser);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            user.setId(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setName(resultSet.getString(4));
            user.setRole(resultSet.getString(5));
            user.setGroup(resultSet.getString(6));
            user.setActive(resultSet.getInt(7) == 1 ? true : false);
            user.setBlocking(resultSet.getInt(8) == 1 ? true : false);
            user.setLastLogin(resultSet.getString(9));
            user.setCreate(resultSet.getString(10));
        }
        userMap.put(user.getId(), user);
        return user;
    }

    public User findByLogin(String loginUser) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM user WHERE login = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, loginUser);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            user.setId(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setName(resultSet.getString(4));
            user.setRole(resultSet.getString(5));
            user.setGroup(resultSet.getString(6));
            user.setActive(resultSet.getInt(7) == 1 ? true : false);
            user.setBlocking(resultSet.getInt(8) == 1 ? true : false);
            user.setLastLogin(resultSet.getString(9));
            user.setCreate(resultSet.getString(10));
        }
        userMap.put(user.getId(), user);
        return user;
    }

    public void insert(String... param) throws SQLException {
        if (!findByLogin(param[0]).equals(null)) {
            System.out.println("User is exists!");
            return;
        }
        String sql = "INSERT INTO user ('login', 'password', 'name', 'role', 'group', 'active', 'blocking') VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, param[0]);
        stmt.setString(2, param[1]);
        stmt.setString(3, param[2]);
        stmt.setString(4, param[3]);
        stmt.setString(5, param[4]);
        stmt.setInt(6, 1);
        stmt.setInt(7, 0);
        stmt.executeUpdate();
    }

    public void update(User user) {
        // схожее использование методов чистого JDBC, тело опущено
    }

    public void delete(User user) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, user.getId());

        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            userMap.remove(user.getId());
            System.out.println("User has been successfully deleted!");
        }

    }
}

