package controller;

import core.StudentService;
import data.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shli on 07/08/2017.
 */
@RestController
public class StudentController {
    private StudentService studentService = StudentService.getInstance();

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student)) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
