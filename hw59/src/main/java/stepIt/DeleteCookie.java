package stepIt;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCookie extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (!req.getParameter("key").equals("")) {
            Cookie[] cookies = req.getCookies();
            Cookie cookie = null;
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (req.getParameter("key").equals(c.getName())) {
                        cookie = c;
                        break;
                    }
                }
            }

            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/");

    }
}
