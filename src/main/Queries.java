package main;

public class Queries {
    public static final String query1 = "select * from view1";
    public static final String query2 = "select countryregion.Name as country,extract(year from salesorderheader.orderdate) as year,round(sum(salesorderheader.TotalDue)) as dobit from salesorderheader join address on salesorderheader.ShipToAddressID=address.AddressID\n" +
            "join stateprovince on address.StateProvinceID=stateprovince.StateProvinceID\n" +
            "join countryregion on stateprovince.CountryRegionCode=countryregion.CountryRegionCode group by year,country order by country,year desc;\n";
    public static final String query3 = "select countryregion.Name as country,extract(year from salesorderheader.orderdate) as year,round(sum(salesorderheader.TotalDue)) as dobit,\n" +
            "case\n" +
            "when sum(salesorderheader.TotalDue) >=0 and sum(salesorderheader.TotalDue) <=99 then 'slaba'\n" +
            "when sum(salesorderheader.TotalDue) >=100 and sum(salesorderheader.TotalDue) <=999 then 'prosecna'\n" +
            "when sum(salesorderheader.TotalDue) >=1000 and sum(salesorderheader.TotalDue) <=9999 then 'fina'\n" +
            "Else 'odlicna'\n" +
            "END AS kvalifikacija\n" +
            "from salesorderheader join address on salesorderheader.ShipToAddressID=address.AddressID\n" +
            "join stateprovince on address.StateProvinceID=stateprovince.StateProvinceID\n" +
            "join countryregion on stateprovince.CountryRegionCode=countryregion.CountryRegionCode group by year,country order by country,year desc;\n";
    public static final String query5 = "select t.TerritoryID, t.SalesPersonID, max(broj_porudzbina) from (select salesperson.TerritoryID, salesorderheader.SalesPersonID, count(SalesOrderID) as 'broj_porudzbina' from salesorderheader join salesperson on salesorderheader.SalesPersonID = salesperson.SalesPersonID group by salesorderheader.SalesPersonID) as t group by t.TerritoryID";
    public static final String query6 = "select currency.name,count(currency.name) as counter from (SELECT coalesce(CurrencyRateID, 13532) as CurrencyRateID FROM salesorderheader) as\n" +
            " salesorderheader left join currencyrate on salesorderheader.CurrencyRateID=currencyrate.CurrencyRateID\n" +
            " left join currency on currencyrate.ToCurrencyCode= currency.CurrencyCode group by currency.name order by counter desc\n";
    public static final String query7 = "";
    public static final String query8 = "select ProductID, Name, round(sum(TotalDue),2) as 'total' from product_view group by Name order by total";
    public static final String query10 = "select * from view10";
    public static final String query13_1 = "select DepartmentID, Name, round(avg(Rate),2) as 'Prosecna satnica' from most_recent_employee_rate natural join active_employees_department_view group by DepartmentID order by DepartmentID";
    public static final String query13_2 = "select round(avg(married),2) as 'Average married' from (select DepartmentID, Name, count(MaritalStatus) as 'married' from active_employees_department_view join employee on active_employees_department_view.EmployeeID = employee.EmployeeID where MaritalStatus='M' group by DepartmentID) as t";
    public static final String query13_3 = "select DepartmentID, Name, ROUND(((100 * SUM((CASE WHEN (employee.Gender = 'f') THEN 1 ELSE 0 END))) / COUNT(employee.EmployeeID)),2) as 'Percent women' from active_employees_department_view join employee on active_employees_department_view.EmployeeID = employee.EmployeeID group by Name";
    public static final String query13_4 = "select DepartmentID, Name, round(avg(timestampdiff(year, BirthDate, curdate())),2) as 'Age' from active_employees_department_view join employee on active_employees_department_view.EmployeeID = employee.EmployeeID group by DepartmentID";
    public static final String query13_5 = "select DepartmentID, Name, round(avg(timestampdiff(year, HireDate, curdate())),2) as 'Years employed' from active_employees_department_view join employee on active_employees_department_view.EmployeeID = employee.EmployeeID group by DepartmentID";
}
