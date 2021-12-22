package ir.Me.session_8.e29;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
    final static Logger logger = Logger.getLogger(JdbcTest.class);

    public static void main(String[] args) {
        logger.info("statement:");
        statementTest();
        logger.info("preparedStatement:");
        preparedStatementTest();
    }

    private static void statementTest() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DbConnector.connectToDb();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT test_cars_id, name, machine_code, karkard FROM test_cars")) {
            getResultset(cars, resultSet);
        } catch (SQLException e) {
            logger.error(e);
        }
        cars.stream().forEach(c -> logger.info(c));
    }

    private static void getResultset(List<Car> cars, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Car car = new Car();
            car.id = resultSet.getInt(1);
            car.name = resultSet.getString(2);
            car.machineCode = resultSet.getShort(3);
            car.karkard = resultSet.getLong(4);
            cars.add(car);
        }
    }

    private static void preparedStatementTest() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DbConnector.connectToDb();
             PreparedStatement statement = createPreparedStatement(connection);
             ResultSet resultSet = statement.executeQuery()) {
            getResultset(cars, resultSet);
        } catch (SQLException e) {
            logger.error(e);
        }
        cars.stream().forEach(c -> logger.info(c));
    }

    private static PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement
                ("SELECT test_cars_id, name, machine_code, karkard FROM test_cars WHERE karkard > ?");
        statement.setInt(1, 0);
        return statement;
    }
}

class Car {
    int id;
    String name;
    short machineCode;
    long karkard;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", machineCode=" + machineCode +
                ", karkard=" + karkard +
                '}';
    }
}