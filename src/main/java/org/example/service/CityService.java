package org.example.service;

import org.example.connectionManager.ConnectionManager;
import org.example.dao.CityDAO;
import org.example.entity.City;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityService implements CityDAO {
    private static final String ADD = "INSERT INTO city(name) VALUES(?)";
    private static final String DELETE = "DELETE FROM city WHERE id=? AND name=?";
    private static final String UPDATE = "UPDATE city SET name=? WHERE id=? AND name=?";
    private static final String GET = "SELECT id, name FROM city WHERE id=?";
    private static final String GET_BY_NAME = "SELECT id,name FROM city WHERE name=?";

    private static final String GET_ALL = "SELECT id,name FROM city";


    @Override
    public City getById(Long id) {


        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("id"));
                city.setName(resultSet.getString("name"));
                return city;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(City city) {

        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, city.getId().toString());
            statement.setString(2, city.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(City city) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setString(1, city.getId().toString());
            statement.setString(2,city.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(City city) {


        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, city.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public City getByName(String name) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("id"));
                city.setName(resultSet.getString("name"));
                return city;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<City> getAll() {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<City> res = new ArrayList<>();
            if (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("id"));
                city.setName(resultSet.getString("name"));
                res.add(city);
            } else {
                return null;
            }
            return res;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}