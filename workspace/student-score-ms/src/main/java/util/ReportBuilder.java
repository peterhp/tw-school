package util;

import data.Report;
import data.ReportItem;
import data.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shli on 28/07/2017.
 */
public class ReportBuilder {
    public static Report generateReport(List<Student> students) {
        return new Report(students.stream()
                .map(stu -> new ReportItem(stu))
                .collect(Collectors.toList()));
    }
}
