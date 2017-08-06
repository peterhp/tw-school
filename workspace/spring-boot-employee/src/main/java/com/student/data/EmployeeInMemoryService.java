package com.student.data;

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
        employees.put("E003", new Employee("E003", "San", "BA"));
        employees.put("E004", new Employee("E004", "Si", "Dev"));
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
}
