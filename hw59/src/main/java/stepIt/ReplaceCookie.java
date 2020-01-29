package stepIt;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;

public class ReplaceCookie extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals(req.getParameter("key"))) {
                    if (!"".equals(req.getParameter("value"))) {
                        c.setValue(req.getParameter("value"));
                    } else {
                        c.setValue(c.getValue());
                    }

                    if (!"".equals(req.getParameter("time life"))) {
                        c.setMaxAge(Integer.parseInt(req.getParameter("time life")));
                    } else {
                        c.setMaxAge(c.getMaxAge());
                    }
                    resp.addCookie(c);
                }
            }

        }

        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
