package RegistrationServlet.it;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AdminServlet extends HttpServlet {
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "qwerty";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

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
            writer.print(Conteiner.builder);
        }else {
            writer.println("Invalid data.Check password or login.");
        }
    }
}
