package stepIt;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCookie extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        if (!"".equals(req.getParameter("key"))) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals(req.getParameter("key"))) {
                        c.setMaxAge(0);
                        resp.addCookie(c);
                        break;
                    }
                }
            }

        }
        resp.sendRedirect(getServletContext().getContextPath() + "/");

    }
}
