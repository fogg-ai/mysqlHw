package stepIt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;

public class ReplaceCookie extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (req.getParameter("key").equals(c.getName())) {
                    cookie = c;
                    if (!"".equals(req.getParameter("value"))) {
                        cookie.setValue(req.getParameter("value"));
                    } else {
                        cookie.setValue(c.getValue());
                    }

                    if (!"".equals(req.getParameter("time life"))) {
                        cookie.setMaxAge(Integer.parseInt(req.getParameter("time life")));
                    } else {
                        cookie.setMaxAge(c.getMaxAge());
                    }


                }
            }
            if (!req.getParameter("key").equals("")) {
                resp.addCookie(cookie);
            }
        }

        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
