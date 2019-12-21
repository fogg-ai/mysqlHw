package servletShop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Buy extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (Connection conn = DriverManager.getConnection(urlDb, userDb, passDb)) {
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("TRUNCATE TABLE  orders ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter writer = response.getWriter();

        try(FileReader reader = new FileReader("..//webapps//hw53_1_war//html//buy.html")){
            int c;
            while ((c = reader.read()) != -1){
                writer.append((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
