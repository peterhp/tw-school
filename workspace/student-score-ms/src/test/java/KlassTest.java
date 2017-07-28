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
    public void should_succeed_to_add_new_student_into_class() throws Exception {
        // given
        Student student = new Student("S003", "张三", 75, 95, 80, 80);
        Klass klass = new Klass();

        // when
        boolean flag = klass.addStudent(student);

        // then
        assertThat(flag, is(true));
        assertThat(klass.getStudent("S003").getName(), is("张三"));
    }

    @Test
    public void should_return_false_when_add_existed_student_into_class() throws Exception {
        // given
        Student student = new Student("S003", "张三", 75, 95, 80, 80);

        Klass klass = new Klass();
        klass.addStudent(new Student("S003", "张三", 75, 95, 80, 80));

        // when
        boolean flag = klass.addStudent(student);

        // then
        assertThat(flag, is(false));
    }
}
