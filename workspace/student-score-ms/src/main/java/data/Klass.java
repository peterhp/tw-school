package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 27/07/2017.
 */
public class Klass {
    private Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        this.students.put(student.getId(), student);
    }

    public Student getStudent(String stuId) {
        return this.students.get(stuId);
    }
}
