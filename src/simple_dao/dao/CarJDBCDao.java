package simple_dao.dao;

import simple_dao.entity.Car;

import java.sql.*;

public class CarJDBCDao implements CarDAO {

    public void add(Car car){
        Connection connection = null;
        connection = getConnection();

        PreparedStatement statement;

        try{
            int markId = getMarkId(car.getMark(), connection);
            if(markId == -1){
                statement = connection.prepareStatement("INSERT INTO mark(mark) VALUES (?)");
                statement.setString(1, car.getMark());
                statement.execute();
                ResultSet rs = statement.executeQuery("SELECT MAX(id) FROM mark");
                if(rs.next()){
                    markId = rs.getInt(1);
                }

            }

            statement = connection.prepareStatement("INSERT INTO car(mark_id,model,price) VALUES (?,?,?)");
            statement.setInt(1, markId);
            statement.setString(2, car.getModel());
            statement.setDouble(3, car.getPrice());
            statement.execute();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public double getPriceByModel(String model){
        Connection connection = null;

        try{
            connection = getConnection();
            PreparedStatement statement;
            statement = connection.prepareStatement("SELECT price FROM car where model = (?)");
            statement.setString(1,model);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0.0;
    }

    private int getMarkId(String markName, Connection connection){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM  mark WHERE mark = ?");
            preparedStatement.setString(1, markName);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;

    }


    private Connection getConnection(){

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
