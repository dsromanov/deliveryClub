package org.example.daoImplement;

import org.example.connectionManager.ConnectionManager;
import org.example.dao.CityDAO;
import org.example.entity.City;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDAO {
    private static final String ADD = "INSERT INTO city(name) VALUES(?)";
    private static final String DELETE = "DELETE FROM city WHERE id=? AND name=?";
    private static final String UPDATE = "UPDATE city SET name=? WHERE id=? AND name=?";
    private static final String GET = "SELECT id, name FROM city WHERE id=?";
    private static final String GET_BY_NAME = "SELECT id,name FROM city WHERE name=?";

    private static final String GET_ALL = "SELECT id,name FROM city";
    private final ConnectionManager builder = new ConnectionManager();
    protected Connection getConnection() throws SQLException {
        return builder.openConnection();
    }


    @Override
    public City getById(Long id) {


        try (Connection connection = getConnection()) {
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

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setLong(1, city.getId());
            statement.setString(2, city.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(City city) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, city.getId());
            statement.setString(2, city.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(City city) {


        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, city.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public City getByName(String name) {
        try (Connection connection = getConnection()) {
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
        List<City> res = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getLong("id"));
                city.setName(resultSet.getString("name"));
                res.add(city);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}