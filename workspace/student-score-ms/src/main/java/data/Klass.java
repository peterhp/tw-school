package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 27/07/2017.
 */
public class Klass {
    private Map<String, Student> students = new HashMap<>();

    public boolean addStudent(Student student) {
        if (!students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return true;
        }
        return false;
    }

    public Student getStudent(String stuId) {
        return students.get(stuId);
    }
}
