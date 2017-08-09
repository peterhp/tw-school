package controller;

import exception.UnexistedStudentException;
import model.Courses;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IStudentService;

import java.util.List;

/**
 * Created by Shli on 07/08/2017.
 */
@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student)) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/{sid}/scores", method = RequestMethod.GET)
    public Courses getStudentScores(@PathVariable("sid") String sid) throws Exception {
        return studentService.getStudentScores(sid);
    }

    @RequestMapping(value = "/{sid}/scores", method = RequestMethod.PUT)
    public void updateStudentScores(@PathVariable("sid") String sid,
            @RequestBody Courses courses) throws Exception {
         studentService.updateStudentScores(sid, courses);
    }
}
