package practice_13;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shli on 24/07/2017.
 */
public class Klass {
    private final int number;

    public Klass(int number) {
        this.number = number;
    }

    private Map<String, Student> students = new HashMap<>();

    public void appendMember(Student student) {
        if (!this.isIn(student)) {
            students.put(student.getId(), student);
        }
    }

    public boolean isIn(Student student) {
        return this.students.containsKey(student.getId());
    }

    public int getNumber() {
        return this.number;
    }

    private Student leader = null;

    public void assignLeader(Student student) {
        if (this.isIn(student)) {
            this.leader = student;
        } else {
            System.out.print("It is not one of us.");
        }
    }

    public boolean isLeader(Student student) {
        return (this.leader != null && this.leader.isSameTo(student));
    }
}
