package simple_dao.dao;

public class DAOFactory implements IDAOFactory{
    private static IDAOFactory factory;

    public DAOFactory(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded success!");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static synchronized IDAOFactory getInstance(){
        if(factory == null){
            factory = new DAOFactory();
        }
        return factory;
    }

    public CarDAO getCarDAO(){
        return new CarJDBCDao();
    }

    public ClientDAO getClientDAO(){
        return null;
    }

}
