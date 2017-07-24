package practice_2;

/**
 * Created by Shli on 24/07/2017.
 */
public class Student {
    private String name;
    private int age;
    private int klass;

    public Student(String name, int age, int klass) {
        this.name = name;
        this.age = age;
        this.klass = klass;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old. " +
                "I am a Student. I am at Class %d.",
                this.name, this.age, this.klass);
    }
}
