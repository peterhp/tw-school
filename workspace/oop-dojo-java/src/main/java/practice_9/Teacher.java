package practice_9;

/**
 * Created by Shli on 25/07/2017.
 */
public class Teacher extends Person {
    private Klass klass = null;

    public Teacher(String id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(String id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String self = super.introduce() + " I am a Teacher. ";
        if (this.klass == null) {
            self += "I teach No Class.";
        } else {
            self += String.format("I teach Class %d.", this.klass.getNumber());
        }
        return self;
    }
}
