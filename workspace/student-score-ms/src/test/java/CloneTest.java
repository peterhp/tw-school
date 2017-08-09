import data.Student;
import org.junit.Test;
import util.CloneFactory;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 09/08/2017.
 */
public class CloneTest {
    @Test
    public void should_clone_student_as_a_new_object() throws Exception {
        // given
        Student student = new Student("S001", "yi", 80, 80, 80, 80);

        // when
        Student copied = CloneFactory.cloneStudent(student);
        copied.setName("er");

        // then
        assertThat(copied == student, is(false));
        assertThat(copied.getSid(), is(student.getSid()));
        assertThat(copied.getProgramScore(), is(student.getProgramScore()));

        assertThat(student.getName(), is("yi"));
        assertThat(copied.getName(), is("er"));
    }

    @Test
    public void should_clone_list_and_students_within_it() throws Exception {
        // given
        List<Student> list = Arrays.asList(
                new Student("S001", "yi", 80, 80, 80, 80));

        // when
        List<Student> copied = CloneFactory.cloneStudentList(list);

        // then
        assertThat(copied == list, is(false));
        assertThat(copied.size(), is(list.size()));

        assertThat(copied.get(0) == list.get(0), is(false));
        assertThat(copied.get(0).getSid(), is(list.get(0).getSid()));
    }
}
