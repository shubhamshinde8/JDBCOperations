package JDBC;

import java.sql.*;

public class UpdateQueryWithJDBC {

    final static String url="jdbc:mysql://localhost:3306/accenture";
    final static String userName="root";
    final static String password="23sep";

    final static String update_Operation="update books set bookPrice=2000 where bookName=?";

    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection(url,userName,password);
        PreparedStatement preparedStatement=connection.prepareStatement(update_Operation);

        preparedStatement.setString(1,"swift");
        int record=preparedStatement.executeUpdate();
        if(record>0){
            System.out.println("updated...");
        }else{
            System.out.println("Updation faild");
        }
        preparedStatement.close();
        connection.close();
    }
}
