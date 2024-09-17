package JDBC;

import java.sql.*;
import java.util.function.Predicate;

public class SelectOperationUsingPreparedStatement {

    final static String url="jdbc:mysql://localhost:3306/accenture";
    final static String userName="root";
    final static String password="23sep";

    final static String select_Operation="select * from books where bookId=?";

    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection(url,userName,password);
        PreparedStatement preparedStatement=connection.prepareStatement(select_Operation);

        preparedStatement.setInt(1,3);
        ResultSet rs=preparedStatement.executeQuery();
        while (rs.next()){
            int id = rs.getInt("bookId");
            String name = rs.getString("bookName");
            int price= Integer.parseInt(rs.getString("bookPrice"));

            System.out.println("ID: " + id + ", Name: " + name +" Price: "+price);
        }
        preparedStatement.close();
        connection.close();
    }
}
