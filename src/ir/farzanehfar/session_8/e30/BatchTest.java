package ir.farzanehfar.session_8.e30;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchTest {
    final static Logger logger = Logger.getLogger(BatchTest.class);

    public static void main(String[] args) {
        int startId = 1;
        try (Connection connection = DbConnector.connectToDb();
             PreparedStatement ps = createPreparedStatement(connection)) {

            ps.setInt(1, startId);
            ps.setInt(2, 0);
            ps.setString(3, "N");
            ps.setDate(4, new Date((new java.util.Date()).getTime()));
            ps.setInt(5, 0);
            ps.setString(6, "car " + startId);
            ps.setShort(7, (short) 0);
            ps.setLong(7, 100000 + startId);

            ps.addBatch();

            ps.executeBatch();

        } catch (SQLException e) {
            logger.error(e);
        }
    }

    private static PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement
//                                        1             2           3        4
        ("INSERT INTO TEST_CARS(TEST_CARS_ID, AD_CLIENT_ID, ISACTIVE, UPDATED, " +
//                    5        6        7           8
                " UPDATEDBY, NAME, MACHINE_CODE, KARKARD) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        return statement;
    }
}
