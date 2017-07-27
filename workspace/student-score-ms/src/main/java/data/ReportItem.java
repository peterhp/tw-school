package data;

/**
 * Created by Shli on 27/07/2017.
 */
public class ReportItem {
    private final Student student;
    private final float totalScore;
    private final float averageScore;

    public ReportItem(Student student) {
        this.student = student;

        this.totalScore = this.calcTotalScore();
        this.averageScore = this.calcAverageScore();
    }

    public float getTotalScore() {
        return this.totalScore;
    }

    public float getAverageScore() {
        return this.averageScore;
    }

    private float calcTotalScore() {
        return student.getMath() + student.getChinese() +
                student.getEnglish() + student.getProgram();
    }

    private float calcAverageScore() {
        return calcTotalScore() / 4;
    }
}
