package org.example.entity;

public class FacilityToUser {
    private int userId;
    private int facilityId;
    private boolean isFavourite;
    private short userMark;
    public FacilityToUser(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public short getUserMark() {
        return userMark;
    }

    public void setUserMark(short userMark) {
        this.userMark = userMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacilityToUser that = (FacilityToUser) o;

        if (userId != that.userId) return false;
        if (facilityId != that.facilityId) return false;
        if (isFavourite != that.isFavourite) return false;
        return userMark == that.userMark;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + facilityId;
        result = 31 * result + (isFavourite ? 1 : 0);
        result = 31 * result + (int) userMark;
        return result;
    }

    @Override
    public String toString() {
        return "FacilityToUser{" +
                "userId=" + userId +
                ", facilityId=" + facilityId +
                ", isFavourite=" + isFavourite +
                ", userMark=" + userMark +
                '}';
    }
}
