import data.Klass;
import data.Student;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 27/07/2017.
 */
public class KlassTest {
    @Test
    public void should_add_new_student_into_class() throws Exception {
        // given
        Student student = new Student("S003", "张三", 75, 95, 80, 80);
        Klass klass = new Klass();

        // when
        klass.addStudent(student);

        // then
        assertThat(klass.getStudent("S003").getName(), is("张三"));
    }
}
