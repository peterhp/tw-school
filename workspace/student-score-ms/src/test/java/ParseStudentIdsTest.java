import exception.InvalidStudentIdListFormatException;
import exception.StudentNotExistInClassException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Shli on 27/07/2017.
 */
public class ParseStudentIdsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_invalid_student_ids_format_exception_when_parse_ids_txt_to_retrieve_student_list() throws Exception {
        // given
        String invalidIdsString = "S003 ， #004";
        Klass klass = new Klass();

        // expected
        thrown.expect(InvalidStudentIdListFormatException.class);

        // when
        Parser.parseStudentList(invalidIdsString, klass);
    }

    @Test
    public void should_throw_student_not_exist_exception_after_parse_ids_containing_unexisted_student_id() throws Exception {
        // given
        String idsString = "S003，S006";
        Klass klass = mock(Klass.class);
        when(klass.find("S003")).thenReturn(
                new Student("S003", "张三", 75, 95, 80, 80));
        when(klass.find("S006")).thenReturn(null);

        //expected
        thrown.expect(StudentNotExistInClassException.class);

        // when
        Parser.parseStudentList(idsString, klass);
    }
}
