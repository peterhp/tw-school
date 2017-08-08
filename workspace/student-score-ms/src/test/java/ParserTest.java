import data.Student;
import org.junit.Test;
import util.Parser;

import java.util.Arrays;
import java.util.List;

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
        assertThat(stu.getSid(), is("S003"));
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

    @Test
    public void should_return_id_list_when_parse_student_ids_string() throws Exception {
        // given
        String stuIds = "S003，S004";

        // when
        List<String> ids = Parser.parseStudentIds(stuIds);

        // then
        assertThat(ids, is(Arrays.asList("S003", "S004")));
    }

    @Test
    public void should_return_empty_id_list_when_parse_student_ids_from_invalid_format() throws Exception {
        // given
        String stuIds = "S003，S 04";

        // when
        List<String> ids = Parser.parseStudentIds(stuIds);

        // then
        assertThat(ids.size(), is(0));
    }
}
