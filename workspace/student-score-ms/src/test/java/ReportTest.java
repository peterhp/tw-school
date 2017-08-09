import model.Report;
import model.ReportItem;
import model.Student;
import org.junit.Test;
import util.ReportBuilder;
import util.ReportFormatter;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 27/07/2017.
 */
public class ReportTest {
    @Test
    public void should_generate_report_for_single_student() throws Exception {
        // given
        Student student = new Student("S003", "张三", 75, 95, 80, 80);

        // when
        Report report = ReportBuilder.generateReport(Arrays.asList(student));

        // then
        assertThat(report.getItems().size(), is(1));
        assertThat(report.getItems().get(0).getName(), is("张三"));
        assertThat(report.getItems().get(0).getTotalScore(), is(330f));
        assertThat(report.getItems().get(0).getAverageScore(), is(82.5f));

        assertThat(report.getAverageTotalScore(), is(330f));
        assertThat(report.getMedianTotalScore(), is(330f));
    }

    @Test
    public void should_generate_report_for_two_students() throws Exception {
        // given
        Student stu1 = new Student("S003", "张三", 75, 95, 80, 80);
        Student stu2 = new Student("S004", "李四", 85, 80, 70, 90);

        // when
        Report report = ReportBuilder.generateReport(Arrays.asList(stu1, stu2));

        // then
        assertThat(report.getItems().size(), is(2));
        assertThat(report.getItems().get(0).getName(), is("张三"));
        assertThat(report.getItems().get(0).getTotalScore(), is(330f));
        assertThat(report.getItems().get(0).getAverageScore(), is(82.5f));
        assertThat(report.getItems().get(1).getName(), is("李四"));
        assertThat(report.getItems().get(1).getTotalScore(), is(325f));
        assertThat(report.getItems().get(1).getAverageScore(), is(81.25f));

        assertThat(report.getAverageTotalScore(), is(327.5f));
        assertThat(report.getMedianTotalScore(), is(327.5f));
    }

    @Test
    public void should_print_report_to_txt_format() throws Exception {
        // given
        ReportItem item1 = new ReportItem(new Student("S003", "张三", 75, 95, 80, 80));
        ReportItem item2 = new ReportItem(new Student("S004", "李四", 85, 80, 70, 90));
        Report report = new Report(Arrays.asList(item1, item2));

        // when
        String reportTxt = ReportFormatter.generateReportString(report);

        // then
        String expected = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "李四|85|80|70|90|81.25|325\n" +
                "========================\n" +
                "全班总平均分：327.5\n" +
                "全班总分中位数：327.5";
        assertThat(reportTxt, is(expected));
    }
}
