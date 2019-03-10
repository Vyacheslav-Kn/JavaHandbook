package app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ListServlet")
public class ListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=JavaHandbook";
        String user = "JavaHandbookUser";
        String password = "123456789";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Articles";
            ResultSet resultSet = statement.executeQuery(query);

            List<String> rows = new ArrayList<String>();

            while (resultSet.next()) {
                rows.add(resultSet.getInt("Id") + " " +
                        resultSet.getString("Title") + " " + resultSet.getString("Text"));
            }

            request.setAttribute("data", rows);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
