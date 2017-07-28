import org.junit.Test;
import state.PageState;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 27/07/2017.
 */
public class PageStateTest {
    @Test
    public void should_get_homepage_state_for_default_page_state() throws Exception {
        // when
        PageState state = new PageState();

        // then
        assertThat(state.getPage(), is(PageState.PAGE_HOME));
    }

    @Test
    public void should_turn_add_student_page_state_after_input_command_one() throws Exception {
        // given
        PageState state = new PageState();

        // when
        state.input("1");

        // then
        assertThat(state.getPage(), is(PageState.PAGE_ADD_STUDENT));
    }

    @Test
    public void should_turn_print_report_page_state_after_input_command_two() throws Exception {
        // given
        PageState state = new PageState();

        // when
        state.input("2");

        // then
        assertThat(state.getPage(), is(PageState.PAGE_PRINT_REPORT));
    }

    @Test
    public void should_turn_exit_page_state_after_input_command_three() throws Exception {
        // given
        PageState state = new PageState();

        // when
        state.input("3");

        // then
        assertThat(state.getPage(), is(PageState.PAGE_EXIT));
    }
}
