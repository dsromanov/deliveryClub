package org.example;

import org.example.connectionManager.ConnectionManager;
import org.example.entity.City;
import org.example.service.CityService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        CityService cityService = new CityService();
        City city = new City();
//        city.setName("Helsinki");
//        cityService.add(city);
        List<City> cities = cityService.getAll();
        for (City value : cities) {
            System.out.println(value);
        }
    }
}