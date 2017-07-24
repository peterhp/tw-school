package practice_13;

/**
 * Created by Shli on 24/07/2017.
 */
public class Person {
    private final String id;
    private final String name;
    private final int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.",
                this.name, this.age);
    }

    public String getId() {
        return this.id;
    }

    public boolean isSameTo(Person person) {
        return this.id.equals(person.id);
    }
}
