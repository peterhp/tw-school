package practice_8;

/**
 * Created by Shli on 24/07/2017.
 */
public class Student extends Person {
    private final Klass klass;

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass =  klass;
    }

    public String introduce() {
        return String.format("%s I am a Student. I am at Class %d.",
                super.introduce(), this.klass.getNumber());
    }
}
