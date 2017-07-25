import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Shli on 25/07/2017.
 */
public class ReadFileTest {
    @Test
    public void should_read_all_content_from_txt_file() throws Exception {
        // given
        String filename = "./res/words.txt";

        // when
        String content = new TxtReader().readFromFile(filename);

        // then
        assertEquals(" the day is sunny the the\nthe sunny is is\n", content);
    }
}
