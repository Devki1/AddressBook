package com.bridgelabz.addressbook.model;

public class AddressDetails {
    private String city;
    private String state;
    private Long zip;

    public AddressDetails() {
    }

    public AddressDetails(String city, String state, Long zip) {
        this.city = city;
        this.state = state;
        this.zip = zip;
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

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "AddressDetails{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}