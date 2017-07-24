package practice_13;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Shli on 24/07/2017.
 */
public class Klass {
    private final int number;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private Map<String, Student> students = new HashMap<>();

    public void appendMember(Student student) {
        if (!this.isIn(student)) {
            students.put(student.getId(), student);

            this.notifyStudentJoinedEvent(student);
        }
    }

    public boolean isIn(Student student) {
        return this.students.containsKey(student.getId());
    }

    private Student leader = null;

    public void assignLeader(Student student) {
        if (this.isIn(student)) {
            this.leader = student;

            this.notifyStudentBeLeaderEvent(student);
        } else {
            System.out.print("It is not one of us.");
        }
    }

    public boolean isLeader(Student student) {
        return (this.leader != null && this.leader.isSameTo(student));
    }

    private Map<String, Teacher> teachers = new HashMap<>();

    public void appendTeacher(Teacher teacher) {
        if (!this.isTeacher(teacher)) {
            this.teachers.put(teacher.getId(), teacher);
        }
    }

    public boolean isTeacher(Teacher teacher) {
        return this.teachers.containsKey(teacher.getId());
    }

    private List<NewsListener> listeners = new LinkedList<>();

    public void addListener(NewsListener listener) {
        this.listeners.add(listener);
    }

    private void notifyStudentJoinedEvent(Student student) {
        for (NewsListener listener : this.listeners) {
            listener.replyStudentJoinedClass(student, this);
        }
    }

    private void notifyStudentBeLeaderEvent(Student student) {
        for (NewsListener listener : this.listeners) {
            listener.replyStudentBeLeader(student, this);
        }
    }
}
