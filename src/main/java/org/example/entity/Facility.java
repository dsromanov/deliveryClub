package org.example.entity;

public class Facility {
    private int id;
    private String name;
    private double rating;
    private int cityId;
    private int typeId;
    public Facility(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facility facility = (Facility) o;

        if (id != facility.id) return false;
        if (Double.compare(facility.rating, rating) != 0) return false;
        if (cityId != facility.cityId) return false;
        if (typeId != facility.typeId) return false;
        return name.equals(facility.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + name.hashCode();
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cityId;
        result = 31 * result + typeId;
        return result;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", cityId=" + cityId +
                ", typeId=" + typeId +
                '}';
    }
}
