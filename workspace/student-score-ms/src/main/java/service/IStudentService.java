package service;

import model.Student;

import java.util.List;

/**
 * Created by Shli on 07/08/2017.
 */
public interface IStudentService {
    boolean addStudent(Student student);

    List<Student> findStudents(List<String> ids);
}
