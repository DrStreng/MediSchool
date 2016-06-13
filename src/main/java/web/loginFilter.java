package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Dawid_2 on 2015-01-20.
 */
@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {


    public loginFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String page = req.getRequestURL().toString();
        if (session.getAttribute("user") == null && !page.contains("login")) {
            resp.sendRedirect("http://localhost:8080/MediSchool_war_exploded/home.jsf");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

}
