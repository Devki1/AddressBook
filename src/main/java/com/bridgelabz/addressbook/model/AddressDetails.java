package com.bridgelabz.addressbook.model;

public class AddressDetails {
    public String address;
    public String city;
    public String state;
    public Long zip;

    public AddressDetails() {
    }

    public AddressDetails(String city, String address, String state, Long zip) {
        this.city = city;
        this.address = address;
        this.state = state;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {
        this.city = address;
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
                "address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}