package app.servlets.article;

import app.entities.Article;
import app.repositories.UnitOfWork;
import app.servlets.user.LoginServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ShowServlet")
public class ShowServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("id"));

        try (UnitOfWork db = new UnitOfWork()) {
            Article article = db.getArticleRepository().getById(articleId);
            if (article != null) {
                request.setAttribute("article", article);
                getServletContext().getRequestDispatcher("/views/article/show.jsp").forward(request, response);
                return;
            }
        } catch (SQLException e) {
            logger.error(e);
        }

        response.sendRedirect("/home");
    }
}
