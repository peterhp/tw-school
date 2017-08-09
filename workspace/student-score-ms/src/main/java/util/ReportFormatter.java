package util;

import model.Report;
import model.ReportItem;

/**
 * Created by Shli on 28/07/2017.
 */
public class ReportFormatter {
    public static String generateReportString(Report report) {
        String itemTemplate = "%s|%d|%d|%d|%d|%s|%s\n";
        String reportTemplate =  "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "%s" +
                "========================\n" +
                "全班总平均分：%s\n" +
                "全班总分中位数：%s";

        StringBuilder strItems = new StringBuilder();
        for (ReportItem item : report.getItems()) {
            strItems.append(String.format(itemTemplate, item.getName(), item.getMathScore(),
                    item.getChineseScore(), item.getEnglishScore(), item.getProgramScore(),
                    String.valueOf(item.getAverageScore()), String.valueOf((int)item.getTotalScore())));
        }

        return String.format(reportTemplate, strItems.toString(), String.valueOf(report.getAverageTotalScore()),
                String.valueOf(report.getMedianTotalScore()));
    }
}
