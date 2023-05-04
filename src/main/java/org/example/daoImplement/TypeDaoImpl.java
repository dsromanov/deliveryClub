package org.example.daoImplement;

import org.example.connectionManager.ConnectionManager;
import org.example.dao.TypeDAO;
import org.example.entity.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDaoImpl implements TypeDAO {
    private static final String ADD = "INSERT INTO type(type, typeOfFoodId) VALUES(?,?)";
    private static final String DELETE = "DELETE FROM type WHERE id=?";
    private static final String UPDATE = "UPDATE type SET type=?, typeOfFoodId=? WHERE id=?";
    private static final String GET = "SELECT id, type, typeOfFoodId FROM type WHERE id=?";
    private static final String GET_BY_NAME = "SELECT id,type, typeOfFoodId FROM type WHERE type=?";
    private static final String GET_ALL = "SELECT id,type,typeOfFoodId FROM type";
    private final ConnectionManager builder = new ConnectionManager();
    protected Connection getConnection() throws SQLException {
        return builder.openConnection();
    }


    @Override
    public Type getById(Long id) {


        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Type type = new Type();
                type.setId(resultSet.getLong("id"));
                type.setType(resultSet.getString("type"));
                return type;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Type type) {

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, type.getType());
            statement.setLong(2, type.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Long id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Type type) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, type.getType());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Type getByName(String name) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Type type = new Type();
                type.setId(resultSet.getLong("id"));
                type.setType(resultSet.getString("type"));
                return type;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Type> getAll() {
        List<Type> res = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Type type = new Type();
                type.setId(resultSet.getLong("id"));
                type.setType(resultSet.getString("type"));
                res.add(type);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
