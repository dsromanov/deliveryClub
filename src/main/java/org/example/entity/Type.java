package org.example.entity;

public class Type {
    private Long id;
    private  String type;
    private Long typeOfFoodId;
    public Type(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTypeOfFoodId() {
        return typeOfFoodId;
    }

    public void setTypeOfFoodId(Long typeOfFoodId) {
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
        int result = id.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + (typeOfFoodId != null ? typeOfFoodId.hashCode() : 0);
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
