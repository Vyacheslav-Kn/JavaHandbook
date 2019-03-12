package app.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UnitOfWork implements AutoCloseable{
    private ArticleRepository Articles;
    private UserRepository Users;
    private Connection databaseConnection;

    public UnitOfWork(){
        Properties property = new Properties();
        String connectionSting = property.getProperty("database.connectionString");
        String user = property.getProperty("database.connectionString");
        String password = property.getProperty("database.password");
        initializeConnection(connectionSting, user, password);
        Users = new UserRepository(databaseConnection);
        Articles = new ArticleRepository(databaseConnection);
    }

    private void initializeConnection(String connectionUrl, String user, String password) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            databaseConnection = DriverManager.getConnection(connectionUrl, user, password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        databaseConnection.close();
    }

    public void setArticles(ArticleRepository articles) {
        Articles = articles;
    }

    public UserRepository getUsers() {
        return Users;
    }

    public void setUsers(UserRepository users) {
        Users = users;
    }

    public ArticleRepository getArticles() {
        return Articles;
    }
}
