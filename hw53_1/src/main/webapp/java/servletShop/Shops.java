package servletShop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Shops extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        double cost = 0;
        try (Connection conn = DriverManager.getConnection(urlDb, userDb, passDb)) {
            Statement stmt = conn.createStatement();
            String parameterName = req.getParameter("name");
            String parameterCost = req.getParameter("cost");

            writer.append("<head><link href=\"..//hw53_1_war//css//shop.css\" rel=\"stylesheet\" type=\"text/css\"/></head>");
            writer.append("<table>" +
                    "        <tr>" +
                    "            <th>Id</th>" +
                    "            <th>Name</th>" +
                    "            <th>Cost</th>" +
                    "            <th>Quantity</th>" +
                    "            <th>Add Busked</th>" +
                    "        </tr>");


            if(parameterCost != null) {
                conn.setAutoCommit(false);
                stmt.executeUpdate("INSERT orders (name, cost, quantity) VALUES ('" + parameterName + "'," + parameterCost + "," + 1 + ");");
                stmt.executeUpdate("UPDATE goods SET quantity = quantity - 1 Where name = '" + parameterName + "';");
                conn.commit();
            }


            ResultSet resultSet = stmt.executeQuery("SELECT * FROM goods");
            while (resultSet.next()) {
                if (resultSet.getInt("quantity") > 1) {
                    writer.append("<tr>" +
                            "<th>" + resultSet.getInt("id") + "</th>" +
                            "<th>" + resultSet.getString("name") + "</th>" +
                            "<th>" + resultSet.getDouble("cost") + "</th>" +
                            "<th>" + resultSet.getInt("quantity") + "</th>" +
                            "<th><a class=\"rel\" href=\"shops?name=" + resultSet.getString("name") + "&cost=" + resultSet.getDouble("cost") + "&quantity=" + resultSet.getInt("quantity") + "\" " + "/>Add Bucked</a></th>" +
                            "</tr>");
                     }
            }


            ResultSet resultSetOrders = stmt.executeQuery("SELECT * FROM orders");



            writer.append("<table class=\"busked\">" +
                    "<caption>Busked</caption>" +
                    "        <tr>" +
                    "            <th>Id</th>" +
                    "            <th>Name</th>" +
                    "            <th>Cost</th>" +
                    "            <th>Quantity</th>" +
                    "        </tr>");
            while (resultSetOrders.next()) {
                writer.append("<tr>" +
                        "<th>" + resultSetOrders.getInt("id") + "</th>" +
                        "<th>" + resultSetOrders.getString("name") + "</th>" +
                        "<th>" + resultSetOrders.getDouble("cost") + "</th>" +
                        "<th>" + resultSetOrders.getInt("quantity") + "</th>" +
                        "</tr>");
                cost += Double.parseDouble(String.valueOf(resultSetOrders.getDouble("cost")));
            }
            writer.append("<p><a href=\"buy\">Buy</a>     <span>Cost: " + String.format("%.2f", cost) + "</span></p>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
