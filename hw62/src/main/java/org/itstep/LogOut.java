package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/logout", name = "logOut")
public class LogOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        if(session.getAttribute("reg") != null && session.getAttribute("log") != null ) {
            session.removeAttribute("reg");
            session.removeAttribute("log");

            resp.sendRedirect(getServletContext().getContextPath() + "/");
        }else {
            resp.sendRedirect(getServletContext().getContextPath() + "/");
        }
    }
}
