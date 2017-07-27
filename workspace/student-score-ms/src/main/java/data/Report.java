package data;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shli on 27/07/2017.
 */
public class Report {
    private final List<ReportItem> items = new LinkedList<>();

    private final float averageTotalScore;
    private final float medianTotalScore;

    public Report(Student student) {
        this.items.add(new ReportItem(student));

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
        return total;
    }

    private float calcMedianTotalScore() {
        List<ReportItem> sortedItems = new LinkedList<>(items);
        Collections.sort(sortedItems, new Comparator<ReportItem>() {
            @Override
            public int compare(ReportItem item1, ReportItem item2) {
                return (int)(item1.getTotalScore() - item2.getTotalScore());
            }
        });

        return sortedItems.get(sortedItems.size() / 2).getTotalScore();
    }
}
