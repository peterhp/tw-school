import exception.InvalidStudentFormatException;
import exception.InvalidStudentIdListFormatException;
import exception.StudentNotExistInClassException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shli on 26/07/2017.
 */
public class Parser {
    private static final String REGEX_STUDENT_FORMAT =
            "([^，]+)，(\\w+)，数学：(\\d+)，语文：(\\d+)，英语：(\\d+)，编程：(\\d+)";
    private static final String REGEX_STUDENT_IDS_FORMAT =
            "(\\w+)(，(\\w+))*";

    private static final Pattern pStu = Pattern.compile(REGEX_STUDENT_FORMAT);
    private static final Pattern pIds = Pattern.compile(REGEX_STUDENT_IDS_FORMAT);

    public static Student parseStudent(String stuInfo)
            throws InvalidStudentFormatException {
        if (!validateStudentFormat(stuInfo)) {
            throw new InvalidStudentFormatException();
        }

        return obtainStudent(stuInfo);
    }

    public static List<Student> parseStudentList(String stuIdsInfo, Klass klass)
            throws InvalidStudentIdListFormatException, StudentNotExistInClassException {
        if (!validateStudentIdsFormat(stuIdsInfo)) {
            throw new InvalidStudentIdListFormatException();
        }

        List<String> ids = obtainStudentIdList(stuIdsInfo);

        return obtainStudentList(ids, klass);
    }

    private static boolean validateStudentFormat(String stuInfo) {
        return pStu.matcher(stuInfo).matches();
    }

    private static Student obtainStudent(String stuInfo) {
        Matcher matcher = pStu.matcher(stuInfo);
        matcher.matches();

        return new Student(matcher.group(2), matcher.group(1),
                Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)),
                Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
    }

    private static boolean validateStudentIdsFormat(String stuIdsInfo) {
        return pIds.matcher(stuIdsInfo).matches();
    }

    private static List<String> obtainStudentIdList(String stuIdsInfo) {
        return Arrays.asList(stuIdsInfo.split("，"));
    }

    private static List<Student> obtainStudentList(List<String> ids, Klass klass)
            throws StudentNotExistInClassException {
        List<Student> students = new ArrayList<>();

        for (String id : ids) {
            if (klass.find(id) == null) {
                throw new StudentNotExistInClassException();
            }
        }

        return students;
    }
}
