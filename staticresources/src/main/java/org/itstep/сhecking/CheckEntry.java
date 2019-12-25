package org.itstep.сhecking;

import java.sql.*;

public class CheckEntry {
    private static final String SELECT = "SELECT login, password from users";
    protected Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public CheckEntry(String connectionString, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(connectionString, user, password);
        DatabaseMetaData metaData = connection.getMetaData();
        if (metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        }
    }

    public boolean checkLoginPassword(String loginE, String passwordE) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SELECT);
            while (resultSet.next()) {
                if (loginE.equals(resultSet.getString("login")) && passwordE.equals(resultSet.getString("password"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
