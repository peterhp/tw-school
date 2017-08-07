package service;

import data.Report;
import data.Student;
import exception.InvalidStudentIdsFormatException;
import exception.UnexistedStudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Parser;
import util.ReportBuilder;

import java.util.List;

/**
 * Created by Shli on 07/08/2017.
 */
@Service
public class ReportService implements IReportService {

    private IStudentService studentService;

    @Autowired
    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Report genReport(String ids) throws InvalidStudentIdsFormatException, UnexistedStudentException {
        List<String> idList = Parser.parseStudentIds(ids);
        if (idList.isEmpty()) {
            throw new InvalidStudentIdsFormatException();
        }

        List<Student> students = studentService.findStudents(idList);
        if (students.isEmpty()) {
            throw new UnexistedStudentException();
        }

        return ReportBuilder.generateReport(students);
    }
}
