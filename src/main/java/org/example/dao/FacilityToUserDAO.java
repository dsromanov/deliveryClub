package org.example.dao;

import org.example.entity.FacilityToUser;

import java.util.List;

public interface FacilityToUserDAO {
    //create
    void add(FacilityToUser facilityToUser);

    //read
    List<FacilityToUser> getAll();

    FacilityToUser getByUserAndFacilityId(Long userId, Long facilityId);

    //update
    void update(FacilityToUser facilityToUser);

    //delete
    void remove(Long userId, Long facilityId);
}
