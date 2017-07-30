import app.App;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 30/07/2017.
 */
public class AppTest {
    private static final String MSG_MAIN_MENU =
            "1.添加学生\n2.生成成绩单\n3.退出\n请输入你的选择(1~3):\n";

    @Test
    public void should_print_main_menu_when_app_starts() throws Exception {
        // given
        App app = new App();

        // when
        String msg = app.startup();

        // then
        assertThat(msg, is(MSG_MAIN_MENU));
    }
}
