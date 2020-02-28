package com.kamil.serwis.model.SQL;

import com.kamil.serwis.model.ModelBase;

import javax.persistence.Entity;

@Entity
public class Adress extends ModelBase {

    Adress(){

    }

    private String postCode;
    private String city;
    private String street;
    private String buildingName;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
