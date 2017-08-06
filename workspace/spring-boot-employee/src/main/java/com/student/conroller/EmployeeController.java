package com.student.conroller;

import com.student.data.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 06/08/2017.
 */
@RestController
public class EmployeeController {
    private Map<String, Employee> employees = new HashMap<>();

    public EmployeeController() {
        //employees.put("E003", new Employee("E003", "San", "BA"));
        //employees.put("E004", new Employee("E004", "Si", "Dev"));
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        if (employees.containsKey(employee.getId())) {
            return new ResponseEntity<Object>(HttpStatus.CONFLICT);
        } else {
            employees.put(employee.getId(), employee);
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable(value = "id") String id) {
        if (employees.containsKey(id)) {
            return new ResponseEntity<Employee>(employees.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<Employee []>(
                employees.values().toArray(new Employee[employees.size()]), HttpStatus.OK);
    }
}
