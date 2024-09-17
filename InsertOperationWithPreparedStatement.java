package JDBC;

import java.sql.*;

public class InsertOperationWithPreparedStatement {

    final static String url="jdbc:mysql://localhost:3306/accenture";
    final static String userName="root";
    final static String password="23sep";

    final static String insertOperation="insert into books values(?,?,?)";

    public static void main(String[] args) throws SQLException {

        Connection connection= DriverManager.getConnection(url,userName,password);
        PreparedStatement pstm=connection.prepareStatement(insertOperation);
        pstm.setInt(1,103);
        pstm.setString(2,"Thinking in java");
        pstm.setInt(3,2300);

        int record=pstm.executeUpdate();
        if(record>0){
            System.out.println("Record is inserted  ");
        }else{
            System.out.println("Record is not inserted ");
        }
        connection.close();
        pstm.close();
    }
}
