package org.example.entity;

public class FacilityToUser {
    private Long userId;
    private Long facilityId;
    private boolean isFavourite;
    private short userMark;

    public FacilityToUser() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String isFavourite() {
        String res;
        if (isFavourite) {
            res = "избранное";
        } else {
            res = "не избранное";
        }
        return res;
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
        int result = userId.hashCode();
        result = 31 * result + facilityId.hashCode();
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
