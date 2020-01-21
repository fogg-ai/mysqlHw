package stepIt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;

public class ReplaceCookie extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (req.getParameter("key").equals(c.getName())) {
                    cookie = c;
                    if(!req.getParameter("value").equals("")){
                        cookie.setValue(req.getParameter("value"));
                        System.out.println("value");
                    }else {
                        cookie.setValue(c.getValue());
                    }

                    if(!req.getParameter("time life").equals("")){
                        cookie.setMaxAge(Integer.parseInt(req.getParameter("time life")));
                        System.out.println("time");
                    }else {
                        cookie.setMaxAge(c.getMaxAge());
                    }

                    if (req.getParameter("httpHttps").equals("HTTPS")) {
                        cookie.setHttpOnly(true);
                    }else {
                        cookie.setHttpOnly(false);
                    }
                }
            }
            if(!req.getParameter("key").equals("")) {
                resp.addCookie(cookie);
            }
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
