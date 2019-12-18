package SearchBD;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Main extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String connString = "jdbc:mysql://localhost:3306/filmLife?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String passwordAd = "";
        PrintWriter writer = resp.getWriter();
        String search = req.getParameter("search");
        System.out.println(search);
        String th = "";
        String td = "";

        System.out.println(search);
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

                "</style>" +
                "</head>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(connString, user, passwordAd)) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(search);


            if (search.indexOf("directors") != -1 || search.indexOf("actors") != -1) {
                td = "<td>" +
                        "firstName" +
                        "</td>" +
                        "<td>" +
                        "lastName" +
                        "</td>" +
                        "<td>" +
                        "nationality" +
                        "</td>" +
                        "<td>" +
                        "birth" +
                        "</td>";
            }else if (search.indexOf("genres") != -1){
                td = "<td> genreName </td>";
            }
            writer.append("<table>");
            writer.append("<tr>" +
                    "<td> movieId </td>" +
                    "<td> directorId </td>" +
                    "<td> title </td>" +
                    "<td> realeseYear </td>" +
                    "<td> rating </td>" +
                    "<td> plot </td>" +
                    "<td> movieLength </td>" +
                    td + "</tr>");


            while (resultSet.next()) {
                if (search.indexOf("directors") != -1 || search.indexOf("actors") != -1) {
                    th = "<td>" +
                            resultSet.getString("firstName") +
                            "</td>" +
                            "<td>" +
                            resultSet.getString("lastName") +
                            "</td>" +
                            "<td>" +
                            resultSet.getString("nationality") +
                            "</td>" +
                            "<td>" +
                            resultSet.getDate("birth") +
                            "</td>";
                }else if (search.indexOf("genres") != -1){
                    th = "<td>" +
                            resultSet.getString("genreName") +
                            "</td>";
                }

                writer.append("<tr>" +
                        "<td>" +
                        resultSet.getInt("movieId") +
                        "</td>" +
                        "<td>" +
                        resultSet.getInt("directorId") +
                        "</td>" +
                        "<td>" +
                        resultSet.getString("title") +
                        "</td>" +
                        "<td>" +
                        resultSet.getInt("realeseYear") +
                        "</td>" +
                        "<td>" +
                        resultSet.getInt("rating") +
                        "</td>" +
                        "<td>" +
                        resultSet.getString("plot") +
                        "</td>" +
                        "<td>" +
                        resultSet.getString("movieLength") +
                        "</td>" + th +
                        "</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
