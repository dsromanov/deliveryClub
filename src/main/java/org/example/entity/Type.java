package org.example.entity;

public class Type {
    private int id;
    private  String type;
    private int typeOfFoodId;
    public Type(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeOfFoodId() {
        return typeOfFoodId;
    }

    public void setTypeOfFoodId(int typeOfFoodId) {
        this.typeOfFoodId = typeOfFoodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type1 = (Type) o;

        if (id != type1.id) return false;
        if (typeOfFoodId != type1.typeOfFoodId) return false;
        return type.equals(type1.type);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        result = 31 * result + typeOfFoodId;
        return result;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", typeOfFoodId=" + typeOfFoodId +
                '}';
    }
}
