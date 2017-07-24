package practice_13;

/**
 * Created by Shli on 24/07/2017.
 */
public class Student extends Person {
    public Student(String id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String self = String.format("%s I am a Student. ", super.introduce());

        Klass klass = KlassManager.getManager().getStudentKlass(this);
        if (klass.isLeader(this)) {
            self += String.format("I am Leader of Class %d.", klass.getNumber());
        } else {
            self += String.format("I am at Class %d.", klass.getNumber());
        }

        return self;
    }
}
