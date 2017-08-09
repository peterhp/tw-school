package service;

import model.Klass;
import model.Report;
import model.Student;
import util.ReportBuilder;

import java.util.List;

/**
 * Created by Shli on 30/07/2017.
 */
public class CLIStudentService {
    private static CLIStudentService instance = new CLIStudentService();

    private Klass klass = new Klass();

    private CLIStudentService() {

    }

    public boolean addStudent(Student student) {
        return klass.addStudent(student);
    }

    public List<Student> findStudents(List<String> ids) {
        return klass.getStudents(ids);
    }

    public static Report generateReport(List<Student> students) {
        return ReportBuilder.generateReport(students);
    }

    public static CLIStudentService getInstance() {
        return instance;
    }
}
