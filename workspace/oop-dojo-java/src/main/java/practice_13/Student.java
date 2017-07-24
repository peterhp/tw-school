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
        return String.format("%s I am a Student. I am at Class %d.", super.introduce(),
                KlassManager.getManager().getStudentKlass(this).getNumber());
    }
}
