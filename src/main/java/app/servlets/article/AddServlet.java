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

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user");

        String title = request.getParameter("Title");
        String content = request.getParameter("Content");
        String description = request.getParameter("Description");
        int categoryId = Integer.parseInt(request.getParameter("CategoryId"));
        Article article = new Article(0, title, content, new Date(), userId, categoryId, description);

        try (UnitOfWork db = new UnitOfWork()) {
            db.getArticleRepository().add(article);

            response.sendRedirect("/user/office");
            return;
        } catch (SQLException e) {
            logger.error(e);
        }

        response.sendRedirect("/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/article/add.jsp").forward(request, response);
    }
}
