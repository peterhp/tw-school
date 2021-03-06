package com.employee.controller;

import com.employee.data.Address;
import com.employee.data.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Shli on 06/08/2017.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        if (employeeService.addEmployee(employee)) {
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Object>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable(value = "id") String id) {
        Employee employee = employeeService.getEmployeeById(id);

        return (employee != null ? new ResponseEntity<Employee>(employee, HttpStatus.OK) :
                new ResponseEntity<Object>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(
                employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(
            @PathVariable(value = "id") String id,
            @RequestBody Employee employee) {
        if (employeeService.updateEmployee(employee)) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") String id) {
        if (employeeService.deleteEmployee(id)) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{eid}/addresses/{aid}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployeeAddress(
            @PathVariable(value = "eid") String id,
            @PathVariable(value = "aid") String type,
            @RequestBody Address address) {
        if (employeeService.updateEmployeeAddress(id, type, address)) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }
}
