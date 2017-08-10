package dc;

import model.Courses;
import model.Student;
import util.CloneFactory;

import java.util.*;

/**
 * Created by Shli on 27/07/2017.
 */
public class StudentMemoryStorage {
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

    public boolean contains(String sid) {
        return students.containsKey(sid);
    }

    public void updateStudentCourses(String sid, Courses courses) {
        Student student = students.get(sid);
        if (student != null) {
            student.setCourses(courses);
        }
    }
}
