package service;

import data.Klass;
import data.Report;
import data.Student;
import util.ReportBuilder;

import java.util.LinkedList;
import java.util.List;

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

    public List<Student> findStudents(List<String> ids) {
        List<Student> students = new LinkedList<>();

        for (String id : ids) {
            Student stu = klass.getStudent(id);
            students.add(stu);

            if (stu == null) {
                students.clear();
                break;
            }
        }

        return students;
    }

    public static Report generateReport(List<Student> students) {
        return ReportBuilder.generateReport(students);
    }

    public static StudentService getInstance() {
        return instance;
    }
}
