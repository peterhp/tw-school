package practice_5;

/**
 * Created by Shli on 24/07/2017.
 */
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected String basicIntroduce() {
        return String.format("My name is %s. I am %d years old.",
                this.name, this.age);
    }

    public String introduce() {
        return this.basicIntroduce();
    }
}
