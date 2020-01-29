package stepIt;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        Cookie cookie;
        if(!"".equals(req.getParameter("key"))) {
            cookie = new Cookie(req.getParameter("key"),"");

            if(!"".equals(req.getParameter("value"))){
                cookie.setValue(req.getParameter("value"));
            }
            if(!"".equals(req.getParameter("domain"))) {
                cookie.setDomain(req.getParameter("domain"));
            }
            if(!"".equals(req.getParameter("time life"))) {
                cookie.setMaxAge(Integer.parseInt(req.getParameter("time life")));
            }

            if (req.getParameter("httpHttps").equals("HTTPS")) {
                cookie.setSecure(true);
            }else {
                cookie.setSecure(false);
            }
            resp.addCookie(cookie);
        }


        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
