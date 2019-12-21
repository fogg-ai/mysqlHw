package servletShop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

public class Registration extends HttpServlet {
    private String urlDb;
    private String userDb;
    private String passDb;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        urlDb = getServletContext().getInitParameter("db:url");
        userDb = getServletContext().getInitParameter("db:user");
        passDb = getServletContext().getInitParameter("db:pass");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");
        PrintWriter writer = resp.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(urlDb, userDb, passDb)) {
            Statement stmt = conn.createStatement();

            writer.append("<head><link href=\"..//hw53_1_war//css//headCss.css\" rel=\"stylesheet\" type=\"text/css\"/></head>");
            stmt.executeUpdate("INSERT buyers (first_name, last_name, login, password, age) VALUES ('" + firstName + "','"
                    + lastName + "','" + login + "','" + password + "','" + age + "');");


            writer.append("<div><a href=\"singIn\">Log In</a></div>");
        } catch (SQLException e) {
            writer.append("<head>" +
                        "<style>" +
                            "a{" +
                                "display:block;" +
                                "color:white;" +
                                "text-decoration:none;" +
                                "background: rgb(81, 73, 157);" +
                                "border-radius:4px;" +
                                "padding:10px 40px;" +
                                "margin:0" +
                            "}" +
                        "</style>" +
                    "</head>");
            writer.append("<div><p>This login is busy.</p>" +
                    "<a href=\"registrationPage\">Return to the registration page.</a></div>");
        }
    }
}
