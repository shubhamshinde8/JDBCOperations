package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataWithJDBC {

    final static String url="jdbc:mysql://localhost:3306/accenture";
    final static String userName="root";
    final static String password="23sep";

    final static String insertQuery="insert into books values(103,'thinking in java ',2300";

    public static void main(String[] args) throws SQLException {

        Connection connection= DriverManager.getConnection(url,userName,password);
        Statement statement=connection.createStatement();
        int cnt=statement.executeUpdate(insertQuery);
        if(cnt>0){
            System.out.println("Record inserted ");
        }else {
            System.out.println("Record is not inserted ");
        }
        statement.close();
        connection.close();

    }
}
