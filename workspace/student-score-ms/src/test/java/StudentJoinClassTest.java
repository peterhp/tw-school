import exception.InvalidStudentFormatException;
import exception.StudentExistInClassException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 26/07/2017.
 */
public class StudentJoinClassTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Klass klass = new Klass();

    @Before
    public void setUp() throws Exception {
        klass.addStudent(new Student("S004", "李四", 85, 80, 70, 90));
    }

    @Test
    public void should_throw_invalid_format_exception_when_parse_invalid_student_info_txt() throws Exception {
        // given
        String invalidStudentString = "张三，S003，数学75，语文95，英语80，编程80";

        // expected
        thrown.expect(InvalidStudentFormatException.class);

        // when
        Parser.parseStudent(invalidStudentString);
    }

    @Test
    public void should_add_student_into_class_after_parse_student_info_txt() throws Exception {
        // given
        String studentString = "张三，S003，数学：75，语文：95，英语：80，编程：80";

        // when
        klass.addStudent(Parser.parseStudent(studentString));

        // then
        assertThat(klass.find("S003").getName(), is("张三"));
    }

    @Test
    public void should_throw_exist_exception_when_add_student_into_class_after_parse_existed_student_info_txt() throws Exception {
        // given
        String studentString = "李四，S004，数学：85，语文：80，英语：80，编程：85";

        // expected
        thrown.expect(StudentExistInClassException.class);

        // when
        klass.addStudent(Parser.parseStudent(studentString));
    }
}
