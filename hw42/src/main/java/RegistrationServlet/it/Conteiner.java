package RegistrationServlet.it;

import java.sql.*;

public class Conteiner {

    void push(String login, String password, String gender, String phone, String email, String subs) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connString = "jdbc:mysql://localhost:3306/adminTable?serverTimezone=Europe/Kiev&characterEncoding=utf8";
        String user = "root";
        String passwordAd = "";
        try (Connection conn = DriverManager.getConnection(connString, user, passwordAd)) {
            System.out.println("Connected");

            Statement stmt = conn.createStatement();

            String sql = "INSERT registrationTable (login,password,gender,phone,email,subscribe) values " +
                    "('" + login + "','" + password + "','" + gender + "','" + phone + "','" + email + "','" + subs + "');";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
