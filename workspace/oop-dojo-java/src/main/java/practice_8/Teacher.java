package practice_8;

/**
 * Created by Shli on 24/07/2017.
 */
public class Teacher extends Person {
    private Klass klass = null;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String self = super.introduce() + " I am a Teacher. ";

        if (this.klass == null) {
            self += "I teach No Class.";
        } else {
            self += String.format("I teach Class %d.",
                    this.klass.getNumber());
        }

        return self;
    }

    public String introduceWith(Student student) {
        String intro = super.introduce() + " I am a Teacher. ";

        if (this.klass.isSameTo(student.getKlass())) {
            intro += String.format("I teach %s.", student.getName());
        } else {
            intro += String.format("I don't teach %s.", student.getName());
        }

        return intro;
    }
}
