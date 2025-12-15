package conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=phonebook;encrypt=false;trustServerCertificate=true";
    private static String user = "sa";
    private static String password = "root";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(jdbcURL, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
