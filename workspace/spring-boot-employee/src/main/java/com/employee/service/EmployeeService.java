package com.employee.service;

import com.employee.data.Address;
import com.employee.data.Employee;

import java.util.List;

/**
 * Created by Shli on 06/08/2017.
 */
public interface EmployeeService {
    boolean addEmployee(Employee employee);

    boolean deleteEmployee(String id);

    boolean updateEmployee(Employee employee);

    Employee getEmployeeById(String id);
    List<Employee> getAllEmployees();

    boolean updateEmployeeAddress(String id, String addrType, Address address);
}
