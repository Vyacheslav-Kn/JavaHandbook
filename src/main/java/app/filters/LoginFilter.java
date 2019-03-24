package app.filters;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter {
    public void  init(FilterConfig config) throws ServletException { }

    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        HttpSession session = servletRequest.getSession();

        if (session.getAttribute("user") == null) {
            servletResponse.sendRedirect("register");
        }
        else {
            chain.doFilter(request,response);
        }
    }

    public void destroy( ) {}
}
