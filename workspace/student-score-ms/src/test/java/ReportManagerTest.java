import data.Report;
import data.ReportItem;
import data.Student;
import org.junit.Test;

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
        Report report = new Report(student);

        // then
        assertThat(report.getAverageTotalScore(), is(330));
        assertThat(report.getMedianTotalScore(), is(330));
    }
}
