package com.employee.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 06/08/2017.
 */
public class Employee {
    private String id;
    private String name;
    private String position;

    private Map<String, Address> addresses = new HashMap<>();

    public Employee() {

    }

    public Employee(String id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAddresses(Map<String, Address> addresses) {
        this.addresses = addresses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public void updateAddress(String type, Address address) {
        addresses.put(type, address);
    }
}
