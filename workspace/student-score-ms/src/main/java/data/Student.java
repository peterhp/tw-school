package data;

/**
 * Created by Shli on 27/07/2017.
 */
public class Student {
    private String id;
    private String name;

    private int mathScore;
    private int chineseScore;
    private int englishScore;
    private int programScore;

    public Student(String id, String name, int mathScore, int chinese, int english, int program) {
        this.id = id;
        this.name = name;

        this.mathScore = mathScore;
        this.chineseScore = chinese;
        this.englishScore = english;
        this.programScore = program;
    }

    public Student() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public void setProgramScore(int programScore) {
        this.programScore = programScore;
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
