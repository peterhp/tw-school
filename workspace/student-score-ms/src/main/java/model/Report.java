package model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shli on 27/07/2017.
 */
public class Report {
    private final List<ReportItem> items;

    public Report(List<ReportItem> items) {
        this.items = items;
    }

    public List<ReportItem> getItems() {
        return items;
    }

    public float getAverageTotalScore() {
        float total = 0;
        for (ReportItem item : items) {
            total += item.getTotalScore();
        }
        return (total / items.size());
    }

    public float getMedianTotalScore() {
        List<ReportItem> sortedItems = items.stream()
                .sorted((item1, item2) -> (int)(item1.getTotalScore() - item2.getTotalScore()))
                .collect(Collectors.toList());

        if (sortedItems.size() % 2 == 1) {
            return sortedItems.get(sortedItems.size() / 2).getTotalScore();
        } else {
            return (sortedItems.get(sortedItems.size() / 2 - 1).getTotalScore() +
                    sortedItems.get(sortedItems.size() / 2).getTotalScore()) / 2;
        }
    }
}
