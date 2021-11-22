package main;

import java.sql.*;

public class Procedura12 {
    public static void call(Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call get_products_by_instruction_language()}");
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            System.out.println("Ime prodavnice: " + resultSet.getString("name") + "\t\tBroj zaposlenih: " + resultSet.getString("number_of_employees") + "\t\tFrekvencija isplacivanja: " + resultSet.getString("PayFrequency"));
        }
        callableStatement.close();
        resultSet.close();
    }
}
