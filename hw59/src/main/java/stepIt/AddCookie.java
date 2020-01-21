package stepIt;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie cookie = null;
        if(!req.getParameter("key").equals("")) {
            cookie = new Cookie(req.getParameter("key"), req.getParameter("value"));
            if(!req.getParameter("domain").equals("")) {
                cookie.setDomain(req.getParameter("domain"));
                System.out.println(req.getParameter("time life"));
            }
            if(!req.getParameter("time life").equals("")) {
                cookie.setMaxAge(Integer.parseInt(req.getParameter("time life")));
                System.out.println(req.getParameter("time life"));
            }
            resp.addCookie(cookie);
        }


        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
