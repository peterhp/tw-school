import exception.StudentExistInClassException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 26/07/2017.
 */
public class Klass {
    private Map<String, Student> students = new HashMap<>();

    public void addStudent(Student stu) throws StudentExistInClassException {
        if (students.containsKey(stu.getId())) {
            throw new StudentExistInClassException();
        }

        students.put(stu.getId(), stu);
    }

    public Student find(String stuId) {
        return students.get(stuId);
    }
}
