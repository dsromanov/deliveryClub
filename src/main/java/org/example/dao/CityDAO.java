package org.example.dao;

import org.example.entity.City;

import java.util.List;

public interface CityDAO {
    //create
    void add(City city);

    //read
    List<City> getAll();

    City getByName(String name);

    City getById(Long id);

    //update
    void update(City city);

    //delete
    void remove(City city);
}
