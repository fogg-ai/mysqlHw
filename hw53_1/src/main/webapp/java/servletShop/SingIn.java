package servletShop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SingIn extends HttpServlet {
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
        boolean check = false;
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String search = "SELECT login,password FROM buyers";

        try (Connection conn = DriverManager.getConnection(urlDb, userDb, passDb)) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(search);

            writer.append("<head><link href=\"..//hw53_1_war//css//headCss.css\" rel=\"stylesheet\" type=\"text/css\"/></head>");

            while (resultSet.next()){
                if(login.equals(resultSet.getString("login")) &&
                        password.equals(resultSet.getString("password"))){
                    writer.append("<head><script>window.location = 'shops';</script></head>");
                    break;
                }else {
                    if(check == false) {
                        writer.append("<head>" +
                                "<style>" +
                                "a{" +
                                "margin:0;" +
                                "text-align:center;" +
                                "}" +
                                "</style>" +
                                "</head>");
                        writer.append("<div><p>Login or password does not match, please check and login again.</p>" +
                                "<a href=\"singIn\">Return SingIn</a></div>");
                        check = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
