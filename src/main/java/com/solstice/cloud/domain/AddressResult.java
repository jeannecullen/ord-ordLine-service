package com.solstice.cloud.domain;

public class AddressResult {

    private Long addressId;
    private String streetName;
    private int unit;
    private String city;
    private String state;
    private int zip;
    private String country;

    public AddressResult() {
    }

    public AddressResult(Long addressId, String streetName, int unit, String city, String state, int zip, String country) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.unit = unit;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
