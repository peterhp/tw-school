package practice_13;

/**
 * Created by Shli on 25/07/2017.
 */
public class Computer implements NewsListener {
    private final String name;

    public Computer(String name) {
        this.name = name;
    }

    @Override
    public void replyStudentJoinedClass(Student student, Klass klass) {
        System.out.print(String.format("I am the Machine. I know %s has joined Class %d.",
                student.getName(), klass.getNumber()));
    }

    @Override
    public void replyStudentBeLeader(Student student, Klass klass) {
        System.out.print(String.format("I am the Machine. I know %s become Leader of Class %d.",
                student.getName(), klass.getNumber()));
    }
}
