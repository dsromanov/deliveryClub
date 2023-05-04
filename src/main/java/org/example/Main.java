package org.example;

import org.example.entity.City;
import org.example.daoImplement.CityDaoImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        CityDaoImpl cityDaoImpl = new CityDaoImpl();
        City city = new City();
//        city.setName("Helsinki");
//        cityService.add(city);
       // List<City> cities = cityService.getAll();
     //   for (City value : cities) {
       //     System.out.println(value);
      //  }
        city = cityDaoImpl.getByName("Moscow");
    }
}