package practice_9;

/**
 * Created by Shli on 25/07/2017.
 */
public class Student extends Person {
    private final Klass klass;

    public Student(String id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String self = super.introduce() + " I am a Student. ";
        if (this.klass.isLeader(this)) {
            self += String.format("I am Leader of Class %d.", this.klass.getNumber());
        } else {
            self += String.format("I am at Class %d.", this.klass.getNumber());
        }
        return self;
    }
}
