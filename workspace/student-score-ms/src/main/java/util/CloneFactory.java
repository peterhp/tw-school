package util;

import model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shli on 09/08/2017.
 */
public class CloneFactory {

    public static Student cloneStudent(Student student) {
        return (student != null ? student.clone() : null);
    }
}
