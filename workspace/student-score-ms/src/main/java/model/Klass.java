package model;

import util.CloneFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 27/07/2017.
 */
public class Klass {
    private Map<String, Student> students = new HashMap<>();

    public boolean addStudent(Student student) {
        if (!students.containsKey(student.getSid())) {
            students.put(student.getSid(), student);
            return true;
        }
        return false;
    }

    public Student getStudent(String stuId) {
        return CloneFactory.cloneStudent(students.get(stuId));
    }
}
