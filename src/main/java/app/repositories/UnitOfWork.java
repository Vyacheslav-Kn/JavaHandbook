package app.repositories;

import org.apache.log4j.Logger;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UnitOfWork implements AutoCloseable{
    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private Connection databaseConnection;
    private static final Logger logger = Logger.getLogger(UnitOfWork.class);

    public UnitOfWork() {
        databaseConnection = initializeConnection();
        logger.info("Connection established");
        userRepository = new UserRepository(databaseConnection);
        articleRepository = new ArticleRepository(databaseConnection);
    }

    private Connection initializeConnection() {
        try {
            Properties property = new Properties();
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("config.properties");
            property.load(inputStream);

            String connectionString = property.getProperty("database.connectionString");
            String user = property.getProperty("database.user");
            String password = property.getProperty("database.password");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionString, user, password);
        }
        catch (Exception e) {
            logger.info("Connection failed");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void close() throws SQLException {
        databaseConnection.close();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public ArticleRepository getArticleRepository() {
        return articleRepository;
    }
}
