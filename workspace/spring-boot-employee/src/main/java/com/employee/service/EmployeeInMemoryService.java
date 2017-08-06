package com.employee.service;

import com.employee.data.Address;
import com.employee.data.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shli on 06/08/2017.
 */
@Service
public class EmployeeInMemoryService implements EmployeeService {
    private Map<String, Employee> employees = new HashMap<>();

    public EmployeeInMemoryService() {
        Employee san = new Employee("E003", "San", "BA");
        Employee si = new Employee("E004", "Si", "Dev");

        Address physicalAddr = new Address("Sichuan", "Chengdu", "Gaoxin", "610041");
        Address mailingAddr = new Address("Hubei", "Wuhan", "Hankou", "430000");

        Map<String, Address> sanAddr = new HashMap<>();
        sanAddr.put("physical", physicalAddr);
        sanAddr.put("mailing", mailingAddr);
        san.setAddresses(sanAddr);

        Map<String, Address> siAddr = new HashMap<>();
        siAddr.put("physical", physicalAddr);
        si.setAddresses(siAddr);

        employees.put(san.getId(), san);
        employees.put(si.getId(), si);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (!employees.containsKey(employee.getId())) {
            employees.put(employee.getId(), employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteEmployee(String id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        if (employees.containsKey(employee.getId())) {
            employees.put(employee.getId(), employee);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public boolean updateEmployeeAddress(String id, String addrType, Address address) {
        if (employees.containsKey(id)) {
            employees.get(id).updateAddress(addrType, address);
            return true;
        } else {
            return false;
        }
    }
}
