package main;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        int selection = 0;
        do {
            selection = UserInput.mainMenu();
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adventureworks", "student", "student");
                 Statement statement = connection.createStatement();) {
                execute(selection, connection, statement);
            } catch (SQLException exception) {
                if (exception.getErrorCode() == 1339) {
                    System.out.println("Jezik nije pronadjen."); // za 11. proceduru
                }
                System.out.println(exception.getMessage());
            }
        } while (selection != 0);
    }

    private static void execute(int selection, Connection connection, Statement statement) throws SQLException {
        ResultSet resultSet = null;
        if (selection == 1) {
            resultSet = statement.executeQuery(Queries.query1);
            while (resultSet.next()) {
                System.out.println("Ime proizvoda: " + resultSet.getString("product_name") + "\t\tIme kategorije: " + resultSet.getString("category_name"));
            }
        }
        if (selection == 2) {
            resultSet = statement.executeQuery(Queries.query2);
            while (resultSet.next()) {
                System.out.println("Drzava: " + resultSet.getString("country") + "\t\tGodina: " + resultSet.getString("year") + "\t\tDobit: " + resultSet.getBigDecimal("dobit"));
            }
        }
        if (selection == 3) {
            resultSet = statement.executeQuery(Queries.query3);
            while (resultSet.next()) {
                System.out.println("Drzava: " + resultSet.getString("country") + "\t\tGodina: " + resultSet.getString("year") + "\t\tDobit: " + resultSet.getBigDecimal("dobit") + "\t\tKvalifikacija: " + resultSet.getString("kvalifikacija"));
            }
        }
        if (selection == 4) {
            Procedura4.call(UserInput.input4(), connection);
        }
        if (selection == 5) {
            resultSet = statement.executeQuery(Queries.query5);
            while (resultSet.next()) {
                System.out.println("SalesPersonID: " + resultSet.getString("SalesPersonID") + "\t\tTerritoryID: " + resultSet.getString("TerritoryID") + "\t\tUkupno: " + resultSet.getString("max(broj_porudzbina)"));
            }
        }
        if (selection == 6) {
            resultSet = statement.executeQuery(Queries.query6);
            while (resultSet.next()) {
                System.out.println("Valuta: " + resultSet.getString("name") + "\t\tBroj koriscenja: " + resultSet.getString("counter"));
            }
        }
        if (selection == 8) {
            resultSet = statement.executeQuery(Queries.query8);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ProductID") + "\t\tIme: " + resultSet.getString("Name") + "\t\tUkupna prodaja: " + resultSet.getBigDecimal("total"));
            }
        }
        if (selection == 9) {
            Procedura9.call(UserInput.input9(), connection);
        }
        if (selection == 10) {
            resultSet = statement.executeQuery(Queries.query10);
            while (resultSet.next()) {
                System.out.println("Model ID: " + resultSet.getString("productmodelid") + "\t\tNaziv modela: " + resultSet.getString("Product_Model_Name") + "\t\tJezik: " + resultSet.getString("language"));
            }
        }
        if (selection == 11) {
            Procedura11.call(UserInput.input11(), connection);
        }
        if (selection == 12) {
            Procedura12.call(connection);
        }
        if (selection == 13) {
            departmentAnalysis(statement);
        }
        if (resultSet != null) resultSet.close();
    }

    private static void departmentAnalysis(Statement statement) throws SQLException {
        int analysis;
        ResultSet resultSet = null;
        do {
            analysis = UserInput.departmentAnalysis();
            if (analysis == 1) {
                resultSet = statement.executeQuery(Queries.query13_1);
                while (resultSet.next()) {
                    System.out.println("Department ID: " + resultSet.getString("DepartmentID") + "\t\tProsecna satnica: " + resultSet.getString("Prosecna satnica") + "\t\tNaziv odseka: " + resultSet.getString("Name"));
                }
            }
            if (analysis == 2) {
                resultSet = statement.executeQuery(Queries.query13_2);
                while (resultSet.next()) {
                    System.out.println("Prosecno zaposlenih u braku po odseku: " + resultSet.getString("Average married"));
                }
            }
            if (analysis == 3) {
                resultSet = statement.executeQuery(Queries.query13_3);
                while (resultSet.next()) {
                    System.out.println("Department ID: " + resultSet.getString("DepartmentID") + "\t\tProcenat zena: " + resultSet.getString("Percent women") + "\t\tIme odseka: " + resultSet.getString("Name"));
                }
            }
            if (analysis == 4) {
                resultSet = statement.executeQuery(Queries.query13_4);
                while (resultSet.next()) {
                    System.out.println("Department ID: " + resultSet.getString("DepartmentID") + "\t\tProsecna starost: " + resultSet.getString("Age") + "\t\tNaziv odseka: " + resultSet.getString("Name"));
                }
            }
            if (analysis == 5) {
                resultSet = statement.executeQuery(Queries.query13_5);
                while (resultSet.next()) {
                    System.out.println("Department ID: " + resultSet.getString("DepartmentID") + "\t\tProsecna duzina zaposlenja: " + resultSet.getString("Years employed") + "\t\tNaziv odseka: " + resultSet.getString("Name"));
                }
            }
        } while (analysis != 0);
        if (resultSet != null) resultSet.close();
    }
}
