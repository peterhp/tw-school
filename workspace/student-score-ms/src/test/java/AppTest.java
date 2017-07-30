import app.App;
import app.AppMsg;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 30/07/2017.
 */
public class AppTest {
    @Test
    public void should_return_main_menu_when_app_starts() throws Exception {
        // given
        App app = new App();

        // when
        String msg = app.startup();

        // then
        assertThat(msg, is(AppMsg.PROMPT_MAIN_MENU));
    }

    @Test
    public void should_return_add_student_prompt_when_input_command_one_after_app_starts() throws Exception {
        // given
        App app = new App();
        app.startup();

        // when
        String msg = app.exec("1");

        // then
        assertThat(msg, is(AppMsg.PROMPT_ADD_STUDENT));
    }

    @Test
    public void should_return_print_report_prompt_when_input_command_two_after_app_starts() throws Exception {
        // given
        App app = new App();
        app.startup();

        // when
        String msg = app.exec("2");

        // then
        assertThat(msg, is(AppMsg.PROMPT_PRINT_REPORT));
    }

    @Test
    public void should_return_exit_message_when_input_command_three_after_app_starts() throws Exception {
        // given
        App app = new App();
        app.startup();

        // when
        String msg = app.exec("3");

        // then
        assertThat(msg, is(AppMsg.SIG_EXIT));
    }

    @Test
    public void should_return_main_menu_again_when_input_invalid_command_after_app_starts() throws Exception {
        // given
        App app = new App();
        app.startup();

        // when
        String msg = app.exec("4");

        // then
        assertThat(msg, is(AppMsg.PROMPT_MAIN_MENU));
    }

    @Test
    public void should_return_retry_message_when_input_student_with_invalid_format() throws Exception {
        // given
        App app = new App();
        app.startup();

        String stuInfo = "张三，S003，75，95，80，80";
        app.exec("1");

        // when
        String msg = app.exec(stuInfo);

        // then
        assertThat(msg, is(AppMsg.PROMPT_ADD_STUDENT_RETRY));
    }

    @Test
    public void should_return_success_message_and_main_menu_after_add_student_into_class() throws Exception {
        // given
        App app = new App();
        app.startup();

        String stuInfo = "张三1，S0031，数学：75，语文：95，英语：80，编程：80";
        app.exec("1");

        // when
        String msg = app.exec(stuInfo);

        // then
        String expected = String.format(AppMsg.ALERT_ADD_STUDENT_SUCCESS, "张三1") + AppMsg.PROMPT_MAIN_MENU;
        assertThat(msg, is(expected));
    }

    @Test
    public void should_return_retry_message_when_fail_to_add_existed_student_int_class() throws Exception {
        // given
        App app = new App();
        app.startup();

        String stuInfo = "张三2，S0032，数学：75，语文：95，英语：80，编程：80";
        app.exec("1");
        app.exec(stuInfo);

        app.exec("1");

        // when
        String msg = app.exec(stuInfo);

        // then
        assertThat(msg, is(AppMsg.PROMPT_ADD_STUDENT_RETRY));
    }

    @Test
    public void should_return_retry_message_when_input_invalid_student_ids() throws Exception {
        // given
        App app = new App();
        app.startup();

        String stuIds = "S003，S0 4";
        app.exec("2");

        // when
        String msg = app.exec(stuIds);

        // then
        assertThat(msg, is(AppMsg.PROMPT_PRINT_REPORT_RETRY));
    }
}
