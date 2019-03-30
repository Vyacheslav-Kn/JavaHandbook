package app.servlets;

import app.repositories.UnitOfWork;
import org.apache.log4j.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(HomeServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try(UnitOfWork db = new UnitOfWork()) {
            request.setAttribute("articles", db.getArticleRepository().getAll());
            getServletContext().getRequestDispatcher("/views/index.jsp").forward(request, response);
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}
