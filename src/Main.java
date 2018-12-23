import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded success");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        Connection connection;
        try{
            connection = DriverManager.getConnection(URL,LOGIN, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Connection is open!");
            }
            connection.close();

            if(connection.isClosed()){
                System.out.println("Connection is closed");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
