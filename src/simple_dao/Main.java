package simple_dao;

import simple_dao.dao.CarDAO;
import simple_dao.dao.DAOFactory;
import simple_dao.dao.IDAOFactory;
import simple_dao.entity.Car;

public class Main {

    public static void main(String[] args){
        IDAOFactory factory = DAOFactory.getInstance();
        CarDAO carDAO = factory.getCarDAO();

        System.out.print(carDAO.getPriceByModel("A8"));


    }

}
