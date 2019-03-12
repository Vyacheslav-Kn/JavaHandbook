package app.repositories;

import java.sql.Connection;

public class UserRepository {
    private Connection databaseConnection;

    public UserRepository(Connection connection){
        databaseConnection = connection;
    }


}
