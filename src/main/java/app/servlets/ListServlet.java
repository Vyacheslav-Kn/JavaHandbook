package app.servlets;

import app.repositories.ArticleRepository;
import app.repositories.UnitOfWork;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(name = "ListServlet")
public class ListServlet extends javax.servlet.http.HttpServlet {
    private UnitOfWork db = new UnitOfWork();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ArticleRepository articleRepository = db.getArticleRepository();

        try {
            request.setAttribute("articles", articleRepository.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
