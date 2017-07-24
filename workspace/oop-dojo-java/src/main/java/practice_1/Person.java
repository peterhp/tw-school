package practice_1;

/**
 * Created by Shli on 24/07/2017.
 */
public class Person {
    public String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.",
                this.name, this.age);
    }
}
