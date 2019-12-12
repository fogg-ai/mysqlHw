package RegistrationServlet.it;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class AdminServlet extends HttpServlet {
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "qwerty";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String connString = "jdbc:mysql://localhost:3306/adminTable?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String passwordAd = "";
        PrintWriter writer = resp.getWriter();

        writer.println("<head>" +
                "<style>" +
                "table{" +
                "border:1px solid #ccc;" +
                " margin:20px;" +
                "border-collapse:collapse;}" +
                "th{" +
                "border:1px solid #ccc;" +
                " padding:20px;}" +
                "td{" +
                "border:1px solid #ccc;" +
                " padding:20px;}" +

                "</style>"+
                "</head>");

        if(req.getParameter("login").equals(LOGIN) && req.getParameter("password").equals(PASSWORD)){
            writer.println("<table>" +
                    "<tr>" +
                    "<th>Id</th>" +
                    "<th>Login</th>" +
                    "<th>Password</th>" +
                    "<th>Gender</th>" +
                    "<th>Phone</th>" +
                    "<th>Email</th>" +
                    "<th>Subscribe</th>" +
                    "</tr>");
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            try (Connection conn = DriverManager.getConnection(connString, user, passwordAd)) {

                Statement stmt = conn.createStatement();

                ResultSet resultSet = stmt.executeQuery("SELECT * from registrationTable");
                while (resultSet.next()) {
                    writer.append("<tr>" +
                            "<td>" +
                            resultSet.getInt("id") +
                            "</td>" +
                            "<td>" +
                            resultSet.getString("login") +
                            "</td>" +
                            "<td>" +
                            resultSet.getString("password") +
                            "</td>" +
                            "<td>" +
                            resultSet.getString("gender") +
                            "</td>" +
                            "<td>" +
                            resultSet.getString("phone") +
                            "</td>" +
                            "<td>" +
                            resultSet.getString("email") +
                            "</td>" +
                            "<td>" +
                            resultSet.getString("subscribe") +
                            "</td>" +
                            "</tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            writer.println("Invalid data.Check password or login.");
        }
    }
}
