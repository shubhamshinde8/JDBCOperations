package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteQueryWithJDBC {

    final static String url="jdbc:mysql://localhost:3306/accenture";
    final static String userName="root";
    final static String password="23sep";

    final static String delete_Operation="delete from books where bookName=?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter book Name which you want to delete : ");
        String name=scanner.nextLine();

        Connection connection= DriverManager.getConnection(url,userName,password);
        PreparedStatement preparedStatement=connection.prepareStatement(delete_Operation);

        preparedStatement.setString(1,name);

        int record=preparedStatement.executeUpdate();
        
        if(record>0){
            System.out.println("Deletion succeessful..");
        }else{
            System.out.println("Falid to delete ");
        }

        preparedStatement.close();
        connection.close();
    }
}
