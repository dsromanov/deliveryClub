package org.example.service;

import org.example.connectionManager.ConnectionManager;
import org.example.dao.FacilityToUserDAO;
import org.example.entity.FacilityToUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityToUserService implements FacilityToUserDAO {
    private static final String ADD = "INSERT INTO facility_to_user(userId, facilityId, isFavourite, userMark) VALUES(?,?,?,?)";
    private static final String DELETE = "DELETE FROM facility_to_user WHERE userId=? AND facilityId=?";
    private static final String UPDATE = "UPDATE facility_to_user SET userId, facilityId, isFavourite, userMark WHERE userId=? AND facilityId=?";
    private static final String GET = "SELECT userId, facilityId, isFavourite, userMark FROM facility_to_user WHERE userId=? AND facilityId=?";
    private static final String GET_ALL = "SELECT userId, facilityId, isFavourite, userMark FROM facility_to_user";


    @Override
    public FacilityToUser getByUserAndFacilityId(Long userId, Long facilityId) {

        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setLong(1, userId);
            statement.setLong(2, facilityId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                FacilityToUser facilityToUser = new FacilityToUser();
                facilityToUser.setUserId(resultSet.getLong("userId"));
                facilityToUser.setFacilityId(resultSet.getLong("facilityId"));
                facilityToUser.setFavourite(resultSet.getBoolean("isFavourite"));
                facilityToUser.setUserMark(resultSet.getShort("userMark"));
                return facilityToUser;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(FacilityToUser facilityToUser) {

        try (Connection connection = ConnectionManager.openConnection();) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, facilityToUser.getUserId().toString());
            statement.setString(2, facilityToUser.getFacilityId().toString());
            statement.setString(3, facilityToUser.isFavourite());
            statement.setString(4, String.valueOf(facilityToUser.getUserMark()));
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Long userId, Long facilityId) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, userId);
            statement.setLong(2, facilityId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(FacilityToUser facilityToUser) {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, facilityToUser.getUserId().toString());
            statement.setString(2, facilityToUser.getFacilityId().toString());
            statement.setString(3, facilityToUser.isFavourite());
            statement.setString(4, String.valueOf(facilityToUser.getUserMark()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<FacilityToUser> getAll() {
        try (Connection connection = ConnectionManager.openConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<FacilityToUser> res = new ArrayList<>();
            if (resultSet.next()) {
                FacilityToUser facilityToUser = new FacilityToUser();
                facilityToUser.setUserId(resultSet.getLong("userId"));
                facilityToUser.setFacilityId(resultSet.getLong("facilityId"));
                facilityToUser.setFavourite(resultSet.getBoolean("isFavourite"));
                facilityToUser.setUserMark(resultSet.getShort("userMark"));
                res.add(facilityToUser);
            } else {
                return null;
            }
            return res;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
