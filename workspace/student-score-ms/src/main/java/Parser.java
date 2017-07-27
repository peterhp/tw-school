import exception.InvalidStudentFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shli on 26/07/2017.
 */
public class Parser {
    private static final String REGEX_STUDENT_FORMAT =
            "([^，]+)，(\\w+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)";

    private static final Pattern pStu = Pattern.compile(REGEX_STUDENT_FORMAT);


    public static Student parseStudent(String stuInfo) throws InvalidStudentFormatException {
        if (!validateStudentFormat(stuInfo)) {
            throw new InvalidStudentFormatException();
        }

        return obtainStudent(stuInfo);
    }

    private static boolean validateStudentFormat(String stuInfo) {
        return pStu.matcher(stuInfo).matches();
    }

    private static Student obtainStudent(String stuInfo) {
        Matcher matcher = pStu.matcher(stuInfo);

        return new Student(matcher.group(2), matcher.group(1),
                Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)),
                Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
    }
}
