package core;

import data.Klass;
import data.Student;

/**
 * Created by Shli on 30/07/2017.
 */
public class StudentService {
    private static StudentService instance = new StudentService();

    private Klass klass = new Klass();

    private StudentService() {

    }

    public boolean addStudent(Student student) {
        return klass.addStudent(student);
    }

    public static StudentService getInstance() {
        return instance;
    }
}
