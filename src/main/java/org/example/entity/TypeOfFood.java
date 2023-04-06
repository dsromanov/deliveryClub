package org.example.entity;

import java.util.Objects;

public class TypeOfFood {
    private Long id;
    private String typeOfFood;

    public TypeOfFood() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeOfFood that = (TypeOfFood) o;

        if (id != that.id) return false;
        return Objects.equals(typeOfFood, that.typeOfFood);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + typeOfFood.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TypeOfFood{" +
                "id=" + id +
                ", typeOfFood='" + typeOfFood + '\'' +
                '}';
    }
}
