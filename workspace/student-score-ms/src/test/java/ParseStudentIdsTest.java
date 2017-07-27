import exception.InvalidStudentIdListFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Shli on 27/07/2017.
 */
public class ParseStudentIdsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_invalid_student_ids_format_exception_when_parse_ids_txt_to_retrieve_student_list() throws Exception {
        // given
        String invalidIdsString = "S003 , #004";

        // expected
        thrown.expect(InvalidStudentIdListFormatException.class);

        // when
        Klass klass = new Klass();
        Parser.parseStudentList(invalidIdsString, klass);
    }
}
