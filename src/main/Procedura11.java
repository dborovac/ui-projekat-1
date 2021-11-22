package main;

import java.sql.*;

public class Procedura11 {
    public static void call(String parameter, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call get_products_by_instruction_language(?)}");
        callableStatement.setString(1, parameter);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("ProductID") + "\t\tIme: " + resultSet.getString("product.Name") + "\t\tCena: " + resultSet.getString("ListPrice"));
        }
        callableStatement.close();
        resultSet.close();
    }
}
