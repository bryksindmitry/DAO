package simple_dao.dao;

import simple_dao.entity.Car;

public interface CarDAO {
    void add(Car car);
    double getPriceByModel(String model);
}
