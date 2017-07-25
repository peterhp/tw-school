import java.util.List;

/**
 * Created by Shli on 25/07/2017.
 */
public class MainModule {
    public String getFrequencyInfoForWordsInTxt(String filename) {
        String content = new TxtReader().readFromFile(filename);
        List<String> words = new TxtParser().split(content);

        StatisticUtil util = new StatisticUtil();
        List<WordFrequency> freqList = util.countWordsFrequency(words);
        util.sortWordFrequencyList(freqList);

        return util.getWordFrequencyListInfo(freqList);
    }

    public static void main(String[] args) {
        MainModule module = new MainModule();

        String file = "./res/words.txt";
        String info = module.getFrequencyInfoForWordsInTxt(file);

        System.out.println(info);
    }
}
