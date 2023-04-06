package org.example.dao;

import org.example.entity.Facility;

import java.util.List;

public interface FacilityDAO {
    //create
    void add(Facility facility);

    //read
    List<Facility> getAll();

    Facility getById(Long id);

    Facility getByName(String name);

    //update
    void update(Facility facility);

    //delete
    void remove(Long id);
}
