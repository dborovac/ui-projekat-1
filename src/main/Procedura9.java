package main;

import java.sql.*;

public class Procedura9 {
    public static void call(String parameter, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call procedure_9(?)}");
        callableStatement.setString(1, parameter);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            System.out.println("Kupac: " + resultSet.getString("CustomerID") + "\t\tDrzava: " + resultSet.getString("countrey"));
        }
        callableStatement.close();
        resultSet.close();
    }
}
