import data.Report;
import data.ReportItem;
import data.Student;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 27/07/2017.
 */
public class ReportManagerTest {
    @Test
    public void should_generate_report_item_for_student() throws Exception {
        // given
        Student student = new Student("S003", "张三", 75, 95, 80, 80);

        // when
        ReportItem item = new ReportItem(student);

        // then
        assertThat(item.getTotalScore(), is(330f));
        assertThat(item.getAverageScore(), is(82.5f));
    }

    @Test
    public void should_generate_report_for_single_student() throws Exception {
        // given
        Student student = new Student("S003", "张三", 75, 95, 80, 80);

        // when
        Report report = new Report(Arrays.asList(student));

        // then
        assertThat(report.getAverageTotalScore(), is(330f));
        assertThat(report.getMedianTotalScore(), is(330f));
    }

    @Test
    public void should_generate_report_for_two_students() throws Exception {
        // given
        Student stu1 = new Student("S003", "张三", 75, 95, 80, 80);
        Student stu2 = new Student("S004", "李四", 85, 80, 70, 90);

        // when
        Report report = new Report(Arrays.asList(stu1, stu2));

        // then
        assertThat(report.getAverageTotalScore(), is(327.5f));
        assertThat(report.getMedianTotalScore(), is(327.5f));
    }

    @Test
    public void should_print_report_to_txt_format() throws Exception {
        // given
        Student stu1 = new Student("S003", "张三", 75, 95, 80, 80);
        Student stu2 = new Student("S004", "李四", 85, 80, 70, 90);

        // when
        Report report = new Report(Arrays.asList(stu1, stu2));

        // then
        String expected =
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "李四|85|80|70|90|81.25|325\n" +
                "========================\n" +
                "全班总平均分：327.5\n" +
                "全班总分中位数：327.5";

        assertThat(report.toString(), is(expected));
    }
}
