package practice_7;

/**
 * Created by Shli on 24/07/2017.
 */
public class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach No Class.",
                super.introduce());
    }
}
