import exception.InvalidStudentFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Shli on 26/07/2017.
 */
public class StudentJoinClassTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_invalid_format_exception_when_parse_invalid_student_info_txt() throws Exception {
        // given
        String invalidStudentString = "张三，S003，数学75，语文95，英语80，编程80";

        // expected
        thrown.expect(InvalidStudentFormatException.class);

        // when
        Parser.parseStudent(invalidStudentString);
    }
}
