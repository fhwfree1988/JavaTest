package ir.Me.session_8.e29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection connectToDb() throws SQLException {
        String url = "jdbc:oracle:thin:@192.168.100.3:1521:orcl";
        String userName = "repos";
        String password = "repos";
        return DriverManager.getConnection(url, userName, password);
    }
}
