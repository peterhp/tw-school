package com.employee.data;

/**
 * Created by Shli on 06/08/2017.
 */
public class Address {
    private String province;
    private String city;
    private String street;
    private String zipcode;

    public Address() {

    }

    public Address(String province, String city, String street, String zipcode) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }
}
