import com.sun.org.glassfish.external.statistics.Statistic;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void should_count_frequency_of_each_word_for_given_word_list() throws Exception {
        // given
        List<String> words = Arrays.asList("the", "day", "is", "the", "the", "is");

        // when
        List<WordFrequency> wordFreqList = new StatisticUtil().countWordsFrequency(words);

        // then
        assertEquals(3, wordFreqList.size());
        assertEquals("the", wordFreqList.get(0).getWord());
        assertEquals(3, wordFreqList.get(0).getFrequency());
    }

    @Test
    public void should_sort_word_frequency_list_with_frequency_in_descend_order() throws Exception {
        // given
        List<WordFrequency> wordFreqList = Arrays.asList(new WordFrequency("is", 2),
                new WordFrequency("day", 1), new WordFrequency("the", 3));

        // when
        new StatisticUtil().sortWordFrequencyList(wordFreqList);

        // then
        assertEquals("the", wordFreqList.get(0).getWord());
        assertEquals(3, wordFreqList.get(0).getFrequency());
        assertEquals("day", wordFreqList.get(2).getWord());
        assertEquals(1, wordFreqList.get(2).getFrequency());
    }

    @Test
    public void should_print_word_frequency_list() throws Exception {
        // given
        List<WordFrequency> wordFreqList = Arrays.asList(new WordFrequency("the", 3),
                new WordFrequency("day", 2), new WordFrequency("is", 1));

        // when
        String printMsg = new StatisticUtil().getWordFrequencyListInfo(wordFreqList);

        // then
        assertEquals("the 3\nday 2\nis 1", printMsg);
    }
}
