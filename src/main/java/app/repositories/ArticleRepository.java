package app.repositories;

import app.entities.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private Connection databaseConnection;

    public ArticleRepository(Connection connection){
        databaseConnection = connection;
    }

    public List<Article> getAll() throws SQLException {
        String query = "SELECT * FROM Articles";
        List<Article> articles = new ArrayList<Article>();

        ResultSet resultSet = databaseConnection.createStatement().executeQuery(query);

        while (resultSet.next()) {
            Article article = new Article();

            article.setId(resultSet.getInt("Id"));
            article.setTitle(resultSet.getString("Title"));
            article.setContent(resultSet.getString("Content"));
            article.setPublicationDate(resultSet.getDate("PublicationDate"));

            articles.add(article);
        }

        return articles;
    }

    public Article getById(int id) throws SQLException {
        String query = "SELECT * FROM Articles WHERE Id = ?";
        Article article = null;

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            article = new Article();

            article.setId(resultSet.getInt("Id"));
            article.setTitle(resultSet.getString("Title"));
            article.setContent(resultSet.getString("Content"));
            article.setPublicationDate(resultSet.getDate("PublicationDate"));
        }

        return article;
    }

    public int add(Article article) throws SQLException {
        String query = "INSERT INTO Articles (Title, Content, UserId) VALUES (?,?,?)";

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(1, article.getContent());
        preparedStatement.setInt(1, article.getUserId());

        return preparedStatement.executeUpdate();
    }

    public int update(Article article) throws SQLException {
        String query = "UPDATE Articles SET Title = ?, Content = ?, UserId WHERE Id = ?)";

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(1, article.getContent());
        preparedStatement.setInt(1, article.getUserId());

        return preparedStatement.executeUpdate();
    }
}
