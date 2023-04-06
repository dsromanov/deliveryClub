package org.example.service;

import org.example.connectionManager.ConnectionManager;
import org.example.dao.TypeOfFoodDAO;
import org.example.entity.TypeOfFood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeOfFoodService implements TypeOfFoodDAO {
    private static final String ADD = "INSERT INTO type_of_food(typeOfFoodId) VALUES(?)";
    private static final String DELETE = "DELETE FROM type_of_food WHERE id=? AND typeOfFoodId=?";
    private static final String UPDATE = "UPDATE type_of_food SET typeOfFoodId=? WHERE id=? AND typeOfFoodId=?";
    private static final String GET = "SELECT id, typeOfFoodId FROM type_of_food WHERE id=?";
    private static final String GET_BY_NAME = "SELECT id,typeOfFoodId FROM type_of_food WHERE typeOfFoodId=?";

    private static final String GET_ALL = "SELECT id,typeOfFoodId FROM type_of_food";


    @Override
    public TypeOfFood getById(Long id) {


        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                TypeOfFood typeOfFood = new TypeOfFood();
                typeOfFood.setId(resultSet.getLong("id"));
                typeOfFood.setTypeOfFood(resultSet.getString("type_of_food"));
                return typeOfFood;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(TypeOfFood typeOfFood) {

        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setLong(1, typeOfFood.getId());
            statement.setString(2, typeOfFood.getTypeOfFood());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(TypeOfFood typeOfFood) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, typeOfFood.getId());
            statement.setString(2,typeOfFood.getTypeOfFood());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(TypeOfFood typeOfFood) {


        try (Connection connection = ConnectionManager.openConnection()) {

            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, typeOfFood.getTypeOfFood());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TypeOfFood getByName(String name) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                TypeOfFood typeOfFood = new TypeOfFood();
                typeOfFood.setId(resultSet.getLong("id"));
                typeOfFood.setTypeOfFood(resultSet.getString("type_of_food"));
                return typeOfFood;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TypeOfFood> getAll() {
        List<TypeOfFood> res = new ArrayList<>();
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TypeOfFood typeOfFood = new TypeOfFood();
                typeOfFood.setId(resultSet.getLong("id"));
                typeOfFood.setTypeOfFood(resultSet.getString("type_of_food"));
                res.add(typeOfFood);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
