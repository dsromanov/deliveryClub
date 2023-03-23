package org.example.entity;

import java.sql.Date;
import java.util.Objects;

public class User {
    private int id;
    private String firstName;
    private String midName;
    private String lastName;
    private Date birthdate;
    private String password;
    private String email;
    private boolean isBlocked;
    private int cityId;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (isBlocked != user.isBlocked) return false;
        if (cityId != user.cityId) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!midName.equals(user.midName)) return false;
        if (!Objects.equals(lastName, user.lastName)) return false;
        if (!birthdate.equals(user.birthdate)) return false;
        if (!password.equals(user.password)) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + midName.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + birthdate.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (isBlocked ? 1 : 0);
        result = 31 * result + cityId;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isBlocked=" + isBlocked +
                ", cityId=" + cityId +
                '}';
    }
}
