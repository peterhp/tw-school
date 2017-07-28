package data;

/**
 * Created by Shli on 27/07/2017.
 */
public class ReportItem {
    private static final String REPORT_ITEM = "%s|%d|%d|%d|%d|%s|%s";

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

    @Override
    public String toString() {
        return String.format(REPORT_ITEM, student.getName(), student.getMath(),
                student.getChinese(), student.getEnglish(), student.getProgram(),
                String.valueOf(averageScore), String.valueOf((int)totalScore));
    }
}
