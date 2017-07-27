package data;

/**
 * Created by Shli on 27/07/2017.
 */
public class Student {
    private final String id;
    private final String name;

    private final int math;
    private final int chinese;
    private final int english;
    private final int program;

    public Student(String id, String name, int math, int chinese, int english, int program) {
        this.id = id;
        this.name = name;

        this.math = math;
        this.chinese = chinese;
        this.english = english;
        this.program = program;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
