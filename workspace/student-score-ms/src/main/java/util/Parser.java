package util;

import data.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shli on 30/07/2017.
 */
public class Parser {
    private static final String REG_STUDENT_INFORMATION =
            "([^，]+)，(\\w+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)";

    public static Student parseStudent(String stuInfo) {
        Pattern pattern = Pattern.compile(REG_STUDENT_INFORMATION);
        Matcher matcher = pattern.matcher(stuInfo);

        Student student = null;
        if (matcher.matches()) {
            student = new Student(matcher.group(2), matcher.group(1),
                    Integer.valueOf(matcher.group(3)), Integer.valueOf(matcher.group(4)),
                    Integer.valueOf(matcher.group(5)), Integer.valueOf(matcher.group(6)));
        }

        return student;
    }
}
