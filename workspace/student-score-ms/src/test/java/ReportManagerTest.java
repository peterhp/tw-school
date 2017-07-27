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
        assertThat(item.getTotalScore(), is(330));
        assertThat(item.getAverageScore(), is(82.5));
    }

    @Test
    public void should_generate_report_for_single_student() throws Exception {
        // given
        Student student = new Student("S003", "张三", 75, 95, 80, 80);

        // when
        Report report = new Report(Arrays.asList(student));

        // then
        assertThat(report.getAverageTotalScore(), is(330));
        assertThat(report.getMedianTotalScore(), is(330));
    }

    @Test
    public void should_generate_report_for_two_students() throws Exception {
        // given
        Student stu1 = new Student("S003", "张三", 75, 95, 80, 80);
        Student stu2 = new Student("S004", "李四", 85, 80, 70, 90);

        // when
        Report report = new Report(Arrays.asList(stu1, stu2));

        // then
        assertThat(report.getAverageTotalScore(), is(327.5));
        assertThat(report.getMedianTotalScore(), is(327.5));
    }
}
