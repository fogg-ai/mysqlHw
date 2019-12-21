package org.itstep;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SearchServlet extends HttpServlet {

    String url;
    String user;
    String password;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        url = getServletContext().getInitParameter("db:url");
        user = getServletContext().getInitParameter("db:user");
        password = getServletContext().getInitParameter("db:pass");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = 0;
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        PrintWriter writer = resp.getWriter();

        String select = "SELECT count(*) FROM people.person WHERE first_name =  '" + firstName + "' AND last_name = '" + lastName + "';";
        String index = "create index person_first_name_idx on person (first_name);";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stm = conn.createStatement();
            long startTime = System.currentTimeMillis();
            ResultSet res = stm.executeQuery(select);
            long timeSpent = System.currentTimeMillis() - startTime;
            while (res.next()) {
                count = res.getInt(1);
            }

            writer.println(count);
            writer.println("Program completing " + timeSpent + " milliseconds");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
