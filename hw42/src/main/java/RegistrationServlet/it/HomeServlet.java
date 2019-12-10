package RegistrationServlet.it;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {
    static Conteiner conteiner = new Conteiner();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String subscribe = req.getParameter("subscribe");
        PrintWriter writer = resp.getWriter();
        conteiner.push(login,password,gender,phone,email,subscribe);
        writer.println("<head>" +
                "<style>" +
                "a{text-decoration:none;" +
                "color:white;" +
                "border:2px solid #ccc;" +
                "border-radius:10px;" +
                "padding:10px;" +
                "background:green;}" +
                "</style>" +
                "</head>" +
                "<p>Registration successful.</p>");
        writer.println("<h2><a href='http://localhost:8080/webapp_handle_form_war'>Return to the registration page</a></h2>");
    }
}
