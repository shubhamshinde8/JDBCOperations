package JDBC;

import java.sql.*;

public class SelectOperation {

    final static String url="jdbc:mysql://localhost:3306/accenture";
    final static String userName="root";
    final static String password="23sep";

    final static String select_Operation="select * from books";

    public static void main(String[] args) throws SQLException {
        Connection connection=DriverManager.getConnection(url,userName,password);
        Statement statement=connection.createStatement();

        ResultSet rs=statement.executeQuery(select_Operation);
        while (rs.next()){
            int id = rs.getInt("bookId");
            String name = rs.getString("bookName");
            int price= Integer.parseInt(rs.getString("bookPrice"));

            System.out.println("ID: " + id + ", Name: " + name +" Price: "+price);
        }
    }
}
