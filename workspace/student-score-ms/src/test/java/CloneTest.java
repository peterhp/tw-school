import model.Student;
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
}
