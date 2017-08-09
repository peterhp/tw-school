package model;

/**
 * Created by Shli on 27/07/2017.
 */
public class ReportItem {
    private final String name;

    private final int mathScore;
    private final int chineseScore;
    private final int englishScore;
    private final int programScore;

    public ReportItem(Student student) {
        this.name = student.getName();

        this.mathScore = student.getMathScore();
        this.chineseScore = student.getChineseScore();
        this.englishScore = student.getEnglishScore();
        this.programScore = student.getProgramScore();
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

    public float getTotalScore() {
        return (mathScore + chineseScore + englishScore + programScore);
    }

    public float getAverageScore() {
        return getTotalScore() / 4;
    }
}
