import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 25/07/2017.
 */
public class FrequencyWordsTest {
    @Test
    public void should_split_words_for_given_txt() throws Exception {
        // given
        String txt = " the  day is   sunny the   the\nthe sunny is   is\n ";

        // when
        List<String> words = new TxtParser().split(txt);

        // then
        assertEquals(10, words.size());
        assertEquals("the", words.get(0));
        assertEquals("sunny", words.get(3));
        assertEquals("is", words.get(9));
    }
}
