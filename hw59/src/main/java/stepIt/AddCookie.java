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
        Cookie cookie;
        if(!req.getParameter("key").equals("")) {
            cookie = new Cookie(req.getParameter("key"), req.getParameter("value"));
            if(!req.getParameter("domain").equals("")) {
                cookie.setDomain(req.getParameter("domain"));
            }
            if(!req.getParameter("time life").equals("")) {
                cookie.setMaxAge(Integer.parseInt(req.getParameter("time life")));
            }

            if (req.getParameter("httpHttps").equals("HTTPS")) {
                cookie.setHttpOnly(true);
            }else {
                cookie.setHttpOnly(false);
            }
            resp.addCookie(cookie);
        }


        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
