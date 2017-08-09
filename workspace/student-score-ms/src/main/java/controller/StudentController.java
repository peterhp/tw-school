package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IStudentService;

/**
 * Created by Shli on 07/08/2017.
 */
@RestController
@CrossOrigin("*")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        System.out.println(student.getSid());
        if (studentService.addStudent(student)) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
