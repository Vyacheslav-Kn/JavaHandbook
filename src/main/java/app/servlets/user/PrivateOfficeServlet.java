package app.servlets.user;

import app.entities.Article;
import app.repositories.UnitOfWork;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PrivateOfficeServlet")
public class PrivateOfficeServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user");

        try (UnitOfWork db = new UnitOfWork()) {
            List<Article> userArticles = db.getArticleRepository().getUserArticles(userId);
            request.setAttribute("articles", userArticles);
            getServletContext().getRequestDispatcher("/views/user/office.jsp").forward(request, response);
            return;
        } catch (SQLException e) {
            logger.error(e);
        }

        response.sendRedirect("/home");
    }
}
