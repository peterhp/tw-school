package service;

import dc.StudentMemoryStorage;
import exception.UnexistedStudentException;
import model.Courses;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.StudentRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shli on 09/08/2017.
 */
@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentMemoryStorage studentStorage = new StudentMemoryStorage();

    public boolean addStudent(Student student) {
        studentRepository.save(student);
        return true;
    }

    @Override
    public List<Student> findStudents(List<String> ids) {
        List<Student> students = new LinkedList<>();
        studentRepository.findAll(ids).forEach(students::add);

        if (students.size() != ids.size()) {
            students.clear();
        }
        return students;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new LinkedList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Courses getStudentScores(String sid) throws UnexistedStudentException {
        if (!studentRepository.exists(sid)) {
            throw new UnexistedStudentException();
        }

        return studentRepository.findOne(sid).getCourses();
    }

    @Override
    public void updateStudentScores(String sid, Courses courses) throws UnexistedStudentException {
        if (!studentRepository.exists(sid)) {
            throw new UnexistedStudentException();
        }

        Student student = studentRepository.findOne(sid);
        student.setCourses(courses);
        studentRepository.save(student);
    }
}
