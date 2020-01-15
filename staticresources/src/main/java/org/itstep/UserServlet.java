package org.itstep;

import org.itstep.сhecking.CheckEntry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {

    private CheckEntry checkEntry;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String user = getServletContext().getInitParameter("db.username");
        String pass = getServletContext().getInitParameter("db.password");
        String url = getServletContext().getInitParameter("db.url");
        try {
            checkEntry = new CheckEntry(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String loginE = request.getParameter("loginE");
        String passwordE = request.getParameter("passwordE");
        PrintWriter writer = response.getWriter();
        writer.append("<head><link href=\"static/css/style.css\" rel=\"stylesheet\"/></head>");
        if (checkEntry.checkLoginPassword(loginE, passwordE)) {
            writer.append("Добро пожаловать");
        } else {
            // url закодирован http://localhost:8080/static_resources_war жестко
            // это не хорошо
            writer.append("<script>window.location=\"http://localhost:8080/static_resources_war/\";</script>");
        }

    }
}
