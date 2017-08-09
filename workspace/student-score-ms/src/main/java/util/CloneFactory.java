package util;

import data.Student;

/**
 * Created by Shli on 09/08/2017.
 */
public class CloneFactory {

    public static Student cloneStudent(Student student) {
        return student.clone();
    }
}
