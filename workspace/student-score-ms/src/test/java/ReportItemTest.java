import data.ReportItem;
import data.Student;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 27/07/2017.
 */
public class ReportItemTest {
    @Test
    public void should_calculate_total_and_average_score_for_student() throws Exception {
        // given
        Student student = new Student("S003", "张三", 75, 95, 80, 80);
        ReportItem item = new ReportItem(student);

        // then
        assertThat(item.getTotalScore(), is(330));
        assertThat(item.getAverageScore(), is(82.5));
    }
}
