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
}
