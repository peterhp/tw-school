package service;

import dc.StudentMemoryStorage;
import model.Report;
import model.Student;
import util.ReportBuilder;

import java.util.List;

/**
 * Created by Shli on 30/07/2017.
 */
public class CLIStudentService {
    private static CLIStudentService instance = new CLIStudentService();

    private StudentMemoryStorage studentStorage = new StudentMemoryStorage();

    private CLIStudentService() {

    }

    public boolean addStudent(Student student) {
        return studentStorage.addStudent(student);
    }

    public List<Student> findStudents(List<String> ids) {
        return studentStorage.getStudents(ids);
    }

    public static Report generateReport(List<Student> students) {
        return ReportBuilder.generateReport(students);
    }

    public static CLIStudentService getInstance() {
        return instance;
    }
}
