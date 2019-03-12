package app.repositories;

import java.sql.Connection;

public class ArticleRepository {
    private Connection databaseConnection;

    public ArticleRepository(Connection connection){
        databaseConnection = connection;
    }


}
