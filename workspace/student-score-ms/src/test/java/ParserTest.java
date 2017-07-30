import data.Student;
import org.junit.Test;
import util.Parser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 30/07/2017.
 */
public class ParserTest {
    @Test
    public void should_parse_student_from_txt_containing_student_info() throws Exception {
        // given
        String stuInfo = "张三，S003，数学：75，语文：95，英语：80，编程：80";

        // when
        Student stu = Parser.parseStudent(stuInfo);

        // then
        assertThat(stu.getId(), is("S003"));
        assertThat(stu.getName(), is("张三"));
        assertThat(stu.getMathScore(), is(75));
        assertThat(stu.getChineseScore(), is(95));
        assertThat(stu.getEnglishScore(), is(80));
        assertThat(stu.getProgramScore(), is(80));
    }

    @Test
    public void should_return_null_when_parse_student_from_invalid_string_format() throws Exception {
        // given
        String stuInfo = "张三，S003，75，95，80，80";

        // when
        Student stu = Parser.parseStudent(stuInfo);

        // then
        assertNull(stu);
    }
}
