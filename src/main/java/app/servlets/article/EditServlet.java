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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user");

        try (UnitOfWork db = new UnitOfWork()) {
            String content = request.getParameter("Content");
            int id = Integer.parseInt(request.getParameter("Id"));

            Article article = new Article(id, "", content, new Date(), userId, 0,"");
            db.getArticleRepository().update(article);

            response.sendRedirect("/user/office");
            return;
        } catch (SQLException e) {
            logger.error(e);
        }

        response.sendRedirect("/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("ArticleId"));
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user");

        try (UnitOfWork db = new UnitOfWork()) {
            Article article = db.getArticleRepository().getById(articleId);
            if (article != null && userId == article.getUserId()) {
                request.setAttribute("article", article);
                getServletContext().getRequestDispatcher("/views/article/edit.jsp").forward(request, response);
                return;
            }
        } catch (SQLException e) {
            logger.error(e);
        }

        response.sendRedirect("/home");
    }
}
