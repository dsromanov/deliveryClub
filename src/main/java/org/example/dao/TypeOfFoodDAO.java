package org.example.dao;

import org.example.entity.TypeOfFood;

import java.util.List;

public interface TypeOfFoodDAO {
    //create
    void add(TypeOfFood typeOfFood);

    //read
    List<TypeOfFood> getAll();

    TypeOfFood getByName(String name);
    TypeOfFood getById(Long id);

    //update
    void update(TypeOfFood typeOfFood);

    //delete
    void remove(TypeOfFood typeOfFood);
}
