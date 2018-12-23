package simple_dao.dao;

public interface IDAOFactory {

    CarDAO getCarDAO();
    ClientDAO getClientDAO();

}
