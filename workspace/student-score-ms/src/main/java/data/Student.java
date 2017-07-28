package data;

/**
 * Created by Shli on 27/07/2017.
 */
public class Student {
    private final String id;
    private final String name;

    private final int mathScore;
    private final int chineseScore;
    private final int englishScore;
    private final int programScore;

    public Student(String id, String name, int mathScore, int chinese, int english, int program) {
        this.id = id;
        this.name = name;

        this.mathScore = mathScore;
        this.chineseScore = chinese;
        this.englishScore = english;
        this.programScore = program;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getProgramScore() {
        return programScore;
    }
}
