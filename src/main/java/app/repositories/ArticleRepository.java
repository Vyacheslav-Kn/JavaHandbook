package app.repositories;

import app.entities.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private Connection databaseConnection;

    public ArticleRepository(Connection connection){
        databaseConnection = connection;
    }

    public List<Article> getChunk(int offset, int limit) throws SQLException {
        String query = "SELECT *, Categories.Title as CategoryTitle FROM Articles, Categories " +
                "WHERE Articles.CategoryId = Categories.Id ORDER BY Articles.Id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Article> articles = new ArrayList<Article>();

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, offset);
        preparedStatement.setInt(2, limit);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Article article = new Article();

            article.setId(resultSet.getInt("Id"));
            article.setTitle(resultSet.getString("Title"));
            article.setContent(resultSet.getString("Content"));
            article.setDescription(resultSet.getString("Description"));
            article.setPublicationDate(resultSet.getDate("PublicationDate"));
            article.setUserId(resultSet.getInt("UserId"));
            article.getCategory().setTitle(resultSet.getString("CategoryTitle"));
            article.setCategoryId(resultSet.getInt("CategoryId"));

            articles.add(article);
        }

        return articles;
    }

    public Article getById(int id) throws SQLException {
        String query = "SELECT *, Categories.Title as CategoryTitle FROM Articles, Categories " +
                "WHERE Articles.CategoryId = Categories.Id AND Articles.Id = ?";

        Article article = new Article();

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            article.setId(resultSet.getInt("Id"));
            article.setTitle(resultSet.getString("Title"));
            article.setContent(resultSet.getString("Content"));
            article.setDescription(resultSet.getString("Description"));
            article.setPublicationDate(resultSet.getDate("PublicationDate"));
            article.setUserId(resultSet.getInt("UserId"));
            article.setCategoryId(resultSet.getInt("CategoryId"));
            article.getCategory().setTitle(resultSet.getString("CategoryTitle"));
        }

        return article;
    }

    public int add(Article article) throws SQLException {
        String query = "INSERT INTO Articles " +
                "(Title, Content, UserId, PublicationDate, Description, CategoryId) " +
                "VALUES (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getContent());
        preparedStatement.setInt(3, article.getUserId());
        preparedStatement.setDate(4, new Date(article.getPublicationDate().getTime()));
        preparedStatement.setString(5, article.getDescription());
        preparedStatement.setInt(6, article.getCategoryId());

        return preparedStatement.executeUpdate();
    }

    public int update(Article article) throws SQLException {
        String query = "UPDATE Articles SET Content = ?, Description = ? WHERE Id = ?";

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setString(1, article.getContent());
        preparedStatement.setString(2, article.getDescription());
        preparedStatement.setInt(3, article.getId());

        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String query = "DELETE FROM Articles WHERE Id = ?";

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate();
    }

    public List<Article> getUserArticles(int userId) throws SQLException {
        String query = "SELECT *, Categories.Title as CategoryTitle FROM Articles, Categories " +
                "WHERE Articles.CategoryId = Categories.Id AND Articles.UserId = ?";

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Article> userArticles = new ArrayList<Article>();

        while(resultSet.next()){
            Article article = new Article();

            article.setId(resultSet.getInt("Id"));
            article.setTitle(resultSet.getString("Title"));
            article.setContent(resultSet.getString("Content"));
            article.setDescription(resultSet.getString("Description"));
            article.setPublicationDate(resultSet.getDate("PublicationDate"));
            article.setUserId(resultSet.getInt("UserId"));
            article.setCategoryId(resultSet.getInt("CategoryId"));
            article.getCategory().setTitle(resultSet.getString("CategoryTitle"));

            userArticles.add(article);
        }

        return  userArticles;
    }

    public int getNumberOfRows() throws SQLException {
        String query = "SELECT COUNT(*) NumberOfRows FROM Articles";
        int numberOfRows = 0;

        PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            numberOfRows = resultSet.getInt("NumberOfRows");
        }

        return numberOfRows;
    }
}
