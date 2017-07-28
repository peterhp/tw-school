package data;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shli on 27/07/2017.
 */
public class Report {
    private static final String REPORT_TITLE = "成绩单";
    private static final String REPORT_FIELDS = "姓名|数学|语文|英语|编程|平均分|总分";
    private static final String REPORT_SEPERATOR = "========================";
    private static final String REPORT_AVERAGE_SCORE = "全班总平均分：";
    private static final String REPORT_MEDIAN_SCORE = "全班总分中位数：";

    private final List<ReportItem> items = new LinkedList<>();

    private final float averageTotalScore;
    private final float medianTotalScore;

    public Report(List<Student> students) {
        for (Student student : students) {
            this.items.add(new ReportItem(student));
        }

        this.averageTotalScore = this.calcAverageTotalScore();
        this.medianTotalScore = this.calcMedianTotalScore();
    }

    public float getAverageTotalScore() {
        return averageTotalScore;
    }

    public float getMedianTotalScore() {
        return medianTotalScore;
    }

    private float calcAverageTotalScore() {
        float total = 0;
        for (ReportItem item : items) {
            total += item.getTotalScore();
        }
        return (total / items.size());
    }

    private float calcMedianTotalScore() {
        List<ReportItem> sortedItems = this.getSortedItems();

        if (sortedItems.size() % 2 == 1) {
            return sortedItems.get(sortedItems.size() / 2).getTotalScore();
        } else {
            return (sortedItems.get(sortedItems.size() / 2 - 1).getTotalScore() +
                    sortedItems.get(sortedItems.size() / 2).getTotalScore()) / 2;
        }
    }

    private List<ReportItem> getSortedItems() {
        List<ReportItem> sortedItems = new LinkedList<>(items);
        Collections.sort(sortedItems, new Comparator<ReportItem>() {
            @Override
            public int compare(ReportItem item1, ReportItem item2) {
                return (int)(item1.getTotalScore() - item2.getTotalScore());
            }
        });
        return sortedItems;
    }

    @Override
    public String toString() {
        String txt = REPORT_TITLE + "\n";
        txt += REPORT_FIELDS + "\n";
        txt += REPORT_SEPERATOR + "\n";

        for (ReportItem item : items) {
            txt += item.toString() + "\n";
        }
        txt += REPORT_SEPERATOR + "\n";

        txt += REPORT_AVERAGE_SCORE + this.averageTotalScore + "\n";
        txt += REPORT_MEDIAN_SCORE + this.medianTotalScore;

        return txt;
    }
}
