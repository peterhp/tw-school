package practice_9;

/**
 * Created by Shli on 25/07/2017.
 */
public class Klass {
    private final int number;
    private Student leader = null;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void assignLeader(Student student) {
        this.leader = student;
    }

    public boolean isLeader(Student student) {
        return (this.leader != null && this.leader.isSameTo(student));
    }
}
