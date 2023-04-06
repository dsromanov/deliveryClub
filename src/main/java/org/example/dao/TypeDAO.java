package org.example.dao;
import org.example.entity.Type;

import java.util.List;

public interface TypeDAO {
    //create
    void add(Type type);

    //read
    List<Type> getAll();

    Type getByName(String name);
    Type getById(Long id);

    //update
    void update(Type type);

    //delete
    void remove(Long id);
}
