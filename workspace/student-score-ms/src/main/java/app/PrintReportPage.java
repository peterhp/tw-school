package app;

import core.StudentService;
import data.Student;
import util.Parser;

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
        List<String> ids = Parser.parseStudentIds(input);
        if (ids.isEmpty()) {
            retry = true;
            return super.exec(input);
        }

        List<Student> students = StudentService.getInstance().findStudents(ids);
        if (students.isEmpty()) {
            retry = true;
        }

        return super.exec(input);
    }
}
