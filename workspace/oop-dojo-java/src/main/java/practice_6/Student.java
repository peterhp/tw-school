package practice_6;

/**
 * Created by Shli on 24/07/2017.
 */
public class Student extends Person {
    private final int klass;

    public Student(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Student. I am at Class %d.",
                super.introduce(), this.klass);
    }
}
