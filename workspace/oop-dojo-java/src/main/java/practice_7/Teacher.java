package practice_7;

/**
 * Created by Shli on 24/07/2017.
 */
public class Teacher extends Person {
    private int klass = -1;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String self = String.format("%s I am a Teacher. ",
                super.introduce());

        if (this.klass > 0) {
            self += String.format("I teach Class %d.", this.klass);
        } else {
            self += "I teach No Class.";
        }

        return self;
    }
}
