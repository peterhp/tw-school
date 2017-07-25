import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Shli on 25/07/2017.
 */
public class MainModuleTest {
    @Test
    public void should_print_word_frequency_in_descend_order_for_words_in_txt_file() throws Exception {
        // given
        String filename = "./res/words.txt";

        // when
        String printInfo = new MainModule().getFrequencyInfoForWordsInTxt(filename);

        // then
        assertEquals("the 4\nis 3\nsunny 2\nday 1", printInfo);
    }
}
