package hw6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    private final Connection connection;

    public UserMapper(Connection connection) {
        this.connection  = connection;
    }

    public User findById(int idUser) throws SQLException {
        User user = new User();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM user WHERE id = ?");
        statement.setInt(1, idUser);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            user.setId(resultSet.getLong(1));
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
        return user;
    }

    public void insert(User user) {
        // схожее использование методов чистого JDBC, тело опущено
    }

    public void update(User user) {
        // схожее использование методов чистого JDBC, тело опущено
    }

    public void delete(User user) {
        // схожее использование методов чистого JDBC, тело опущено
    }
}

