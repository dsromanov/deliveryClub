package org.example.service;

import org.example.connectionManager.ConnectionManager;
import org.example.dao.FacilityDAO;
import org.example.entity.Facility;
import org.example.entity.Facility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityService implements FacilityDAO {
    private static final String ADD = "INSERT INTO facility(name, rating, cityId, typeId) VALUES(?,?,?,?)";
    private static final String DELETE = "DELETE FROM facility WHERE id=?";
    private static final String UPDATE = "UPDATE facility SET name=?, rating=?, cityId=?, typeId=? WHERE id=?";
    private static final String GET = "SELECT id, name, rating, cityId, typeId FROM facility WHERE id=?";
    private static final String GET_BY_NAME = "SELECT id,name, rating, cityId, typeId FROM facility WHERE name=?";

    private static final String GET_ALL = "SELECT id,name,rating,cityId, typeId FROM facility";


    @Override
    public Facility getById(Long id) {


        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Facility facility = new Facility();
                facility.setId(resultSet.getLong("id"));
                facility.setName(resultSet.getString("name"));
                facility.setRating(resultSet.getDouble("rating"));
                facility.setCityId(resultSet.getLong("cityId"));
                facility.setTypeId(resultSet.getLong("typeId"));
                return facility;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Facility facility) {

        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, facility.getName());
            statement.setDouble(2, facility.getRating());
            statement.setLong(3, facility.getCityId());
            statement.setLong(4, facility.getTypeId());
            statement.setLong(5, facility.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Long id) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Facility facility) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, facility.getName());
            statement.setDouble(2, facility.getRating());
            statement.setLong(3, facility.getCityId());
            statement.setLong(4, facility.getTypeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Facility getByName(String name) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Facility facility = new Facility();
                facility.setId(resultSet.getLong("id"));
                facility.setName(resultSet.getString("name"));
                facility.setRating(resultSet.getDouble("rating"));
                facility.setCityId(resultSet.getLong("cityId"));
                facility.setTypeId(resultSet.getLong("typeId"));
                return facility;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Facility> getAll() {
        List<Facility> res = new ArrayList<>();
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Facility facility = new Facility();
                facility.setId(resultSet.getLong("id"));
                facility.setName(resultSet.getString("name"));
                facility.setRating(resultSet.getDouble("rating"));
                facility.setCityId(resultSet.getLong("cityId"));
                facility.setTypeId(resultSet.getLong("typeId"));
                res.add(facility);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
