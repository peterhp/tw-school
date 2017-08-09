package app;

import service.CLIStudentService;
import model.Student;
import util.Parser;
import util.ReportFormatter;

import java.util.List;

/**
 * Created by Shli on 30/07/2017.
 */
public class PrintReportPage extends Page {
    private boolean retry = false;

    @Override
    public String display() {
        return (retry ? AppMsg.PROMPT_PRINT_REPORT_RETRY : AppMsg.PROMPT_PRINT_REPORT);
    }

    @Override
    public String exec(String input) {
        List<Student> students = obtainStudents(input);

        if (students.isEmpty()) {
            retry = true;
            return super.exec(input);
        }

        nextPage = new HomePage();

        return ReportFormatter.generateReportString(
                CLIStudentService.generateReport(students)) + "\n";
    }

    private List<Student> obtainStudents(String input) {
        return CLIStudentService.getInstance().findStudents(
                Parser.parseStudentIds(input));
    }
}
