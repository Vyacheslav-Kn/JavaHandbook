package app.repositories;

import app.entities.User;

import java.sql.*;

public class UserRepository {
    private Connection databaseConnection;

    public UserRepository(Connection connection){
        databaseConnection = connection;
    }

    public User getById(int id) throws SQLException {
        String query = "SELECT * FROM Users WHERE Id = ?";
        User user = null;

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            user = new User();

            user.setId(resultSet.getInt("Id"));
            user.setName(resultSet.getString("Name"));
        }

        return user;
    }

    public User getByCredentials(String name, String password) throws SQLException {
        String query = "SELECT * FROM Users WHERE Name = ? AND Password = ?";
        User user = null;

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            user = new User();

            user.setId(resultSet.getInt("Id"));
            user.setName(resultSet.getString("Name"));
        }

        return user;
    }

    public int add(User user) throws SQLException {
        String query = "INSERT INTO Users (Name, Password) VALUES (?,?)";

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs != null && rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }
}
