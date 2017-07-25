import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public void sortWordFrequencyList(List<WordFrequency> wordFreqList) {
        Collections.sort(wordFreqList, new Comparator<WordFrequency>() {
            @Override
            public int compare(WordFrequency freq1, WordFrequency freq2) {
                return freq1.getFrequency() - freq2.getFrequency();
            }
        });
        Collections.reverse(wordFreqList);
    }

    public String getWordFrequencyListInfo(List<WordFrequency> wordFreqList) {
        String info = "";
        for (WordFrequency freq : wordFreqList) {
            info += freq.toString() + "\n";
        }

        return (info.isEmpty() ? "" : info.substring(0, info.length() - 1));
    }
}
