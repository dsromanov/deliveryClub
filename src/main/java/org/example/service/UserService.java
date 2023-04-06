package org.example.service;

import org.example.connectionManager.ConnectionManager;
import org.example.dao.UserDAO;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDAO {
    private static final String ADD = "INSERT INTO user(firstName, midName, lastName, birthdate, password, email, is_blocked, cityId) VALUES(?,?,?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM user WHERE id=?";
    private static final String UPDATE = "UPDATE user SET firstName=?, midName=?, lastName=?, birthdate=?, password=?, email=?, is_blocked=?, cityId=? WHERE id=?";
    private static final String GET = "SELECT id,firstName, midName, lastName, birthdate, password, email, is_blocked, cityId FROM user WHERE id=?";
    private static final String GET_ALL = "SELECT id,firstName, midName, lastName, birthdate, password, email, is_blocked, cityId FROM user";


    @Override
    public User getById(Long id) {


        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setMidName(resultSet.getString("midName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setBirthdate(resultSet.getDate("birthdate"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setBlocked(resultSet.getBoolean("is_blocked"));
                user.setCityId(resultSet.getLong("cityId"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {

        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getMidName());
            statement.setString(3, user.getLastName());
            statement.setDate(4, user.getBirthdate());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.isBlocked());
            statement.setLong(8, user.getCityId());
            statement.setLong(9, user.getId());
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
    public void add(User user) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getMidName());
            statement.setString(3, user.getLastName());
            statement.setDate(4, user.getBirthdate());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.isBlocked());
            statement.setLong(8, user.getCityId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<User> getAll() {
        List<User> res = new ArrayList<>();
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setMidName(resultSet.getString("midName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setBirthdate(resultSet.getDate("birthdate"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setBlocked(resultSet.getBoolean("is_blocked"));
                user.setCityId(resultSet.getLong("cityId"));
                res.add(user);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
