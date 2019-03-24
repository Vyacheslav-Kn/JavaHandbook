package app.servlets;

import app.entities.User;
import app.repositories.UnitOfWork;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int tempUserId = 1;

        try(UnitOfWork db = new UnitOfWork()){
            User user = db.getUserRepository().getById(tempUserId);
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("user", user.getId());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
