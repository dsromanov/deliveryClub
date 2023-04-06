package org.example;

import org.example.connectionManager.ConnectionManager;
import org.example.entity.City;
import org.example.service.CityService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        CityService cityService = new CityService();
        City city = new City();
        System.out.println(cityService.getAll());
    }
}