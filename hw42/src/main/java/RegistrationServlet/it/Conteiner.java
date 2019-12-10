package RegistrationServlet.it;

import java.sql.*;

public class Conteiner {
    static StringBuilder builder = new StringBuilder();
    private int i = 0;

    public static void main(String[] args) {
        new Conteiner().push("Vasya","qwert","dsad","343544354","nick3454@gamilc","yes");
    }
    void push(String login, String password, String gender, String phone, String email, String subs) {
        i++;
        String connString = "jdbc:mysql://localhost:3306/adminTable?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String passwordAd = "";
        try (Connection conn = DriverManager.getConnection(connString, user, passwordAd)) {
            System.out.println("Connected");

            Statement stmt = conn.createStatement();

            String sql = "INSERT registrationTable (login,password,gender,phone,email,subscribe) values " +
                    "('" + login + "','" + password + "','" + gender + "','" + phone + "','" + email + "','" + subs + "');";
            stmt.executeUpdate(sql);

            ResultSet resultSet = stmt.executeQuery("SELECT * from registrationTable");
            while (resultSet.next()) {
                builder.append("<tr>" +
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


    }
}
