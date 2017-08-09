package model;

import util.CloneFactory;

import java.util.*;

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

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public List<Student> getStudents(List<String> ids) {
        List<Student> matched = new LinkedList<>();

        for (String id : ids) {
            if (!students.containsKey(id)) {
                matched.clear();
                break;
            }

            matched.add(students.get(id));
        }

        return matched;
    }
}
