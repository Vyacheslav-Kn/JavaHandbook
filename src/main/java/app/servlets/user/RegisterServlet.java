package app.servlets.user;

import app.entities.User;
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

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/user/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try(UnitOfWork db = new UnitOfWork()) {
            User user = db.getUserRepository().getByCredentials(name, password);
            if(user == null) {
                user = new User(name, password);
                int userId = db.getUserRepository().add(user);
                if(userId > -1) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", userId);
                    response.sendRedirect("/home");
                    return;
                }
            }
            request.setAttribute("registerErrorMessage", "This nickname is already exists");
            getServletContext().getRequestDispatcher("/views/user/register.jsp").forward(request, response);
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}
