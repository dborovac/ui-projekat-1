package main;

import java.sql.*;

public class Procedura4 {
    public static void call(String parameter, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call procedura4(?)}");
        callableStatement.setString(1, parameter);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            System.out.println("Ime prodavnice: " + resultSet.getString("store_name") + "\t\tBroj porudzbina: " + resultSet.getString("number_of_orders") + "\t\tProsecan broj stvari kupljen: " + resultSet.getString("average_number_of_bought_stuff") + "\t\tProfit: " + resultSet.getBigDecimal("amount_of_profit"));
        }
        callableStatement.close();
        resultSet.close();
    }
}
