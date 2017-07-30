import app.App;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 30/07/2017.
 */
public class AppTest {
    private static final String MSG_MAIN_MENU =
            "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n";
    private static final String MSG_ADD_STUDENT =
            "请输入学生信息（格式：姓名，学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提示：\n";

    @Test
    public void should_print_main_menu_when_app_starts() throws Exception {
        // given
        App app = new App();

        // when
        String msg = app.startup();

        // then
        assertThat(msg, is(MSG_MAIN_MENU));
    }

    @Test
    public void should_print_add_student_msg_when_input_command_one_after_app_starts() throws Exception {
        // given
        App app = new App();
        app.startup();

        // when
        String msg = app.exec("1");

        // then
        assertThat(msg, is(MSG_ADD_STUDENT));
    }
}
