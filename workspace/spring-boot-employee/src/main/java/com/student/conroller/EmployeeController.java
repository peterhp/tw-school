package com.student.conroller;

import com.student.data.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 06/08/2017.
 */
@RestController
public class EmployeeController {
    private Map<String, Employee> employees = new HashMap<>();

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        if (employees.containsKey(employee.getId())) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        } else {
            employees.put(employee.getId(), employee);
            return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
        }
    }
}
