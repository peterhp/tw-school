package com.student.conroller;

import com.student.data.Employee;
import com.student.data.EmployeeInMemoryService;
import com.student.data.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Shli on 06/08/2017.
 */
@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        if (employeeService.addEmployee(employee)) {
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Object>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable(value = "id") String id) {
        Employee employee = employeeService.getEmployeeById(id);

        return (employee != null ? new ResponseEntity<Employee>(employee, HttpStatus.OK) :
                new ResponseEntity<Object>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(
                employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        if (employeeService.updateEmployee(employee)) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") String id) {
        if (employeeService.deleteEmployee(id)) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }
}
