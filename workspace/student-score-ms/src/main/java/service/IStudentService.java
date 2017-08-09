package service;

import exception.UnexistedStudentException;
import model.Courses;
import model.Student;

import java.util.List;

/**
 * Created by Shli on 07/08/2017.
 */
public interface IStudentService {
    boolean addStudent(Student student);

    List<Student> findStudents(List<String> ids);

    List<Student> getAllStudents();

    Courses getStudentScores(String sid) throws UnexistedStudentException;

    void updateStudentScores(String sid, Courses courses) throws UnexistedStudentException;
}
