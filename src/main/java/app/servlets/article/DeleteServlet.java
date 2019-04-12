package app.servlets.article;

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

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("ArticleId"));

        try (UnitOfWork db = new UnitOfWork()) {
            db.getArticleRepository().delete(articleId);

            response.sendRedirect("/user/office");
            return;
        } catch (SQLException e) {
            logger.error(e);
        }

        response.sendRedirect("/home");
    }
}
