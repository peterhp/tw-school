import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shli on 25/07/2017.
 */
public class StatisticUtil {
    public List<WordFrequency> countWordsFrequency(List<String> words) {
        List<WordFrequency> freqList = new ArrayList<>();

        for (String word : words) {
            WordFrequency freq = this.findWordFrequency(freqList, word);

            if (freq != null) {
                freq.addFrequency(1);
            } else {
                freqList.add(new WordFrequency(word, 1));
            }
        }

        return freqList;
    }

    private WordFrequency findWordFrequency(List<WordFrequency> freqList, String word) {
        WordFrequency matched = null;
        for (WordFrequency freq : freqList) {
            if (freq.getWord().equals(word)) {
                matched = freq;
                break;
            }
        }
        return matched;
    }
}
