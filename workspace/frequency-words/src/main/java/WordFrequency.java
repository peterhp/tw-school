import java.util.List;

/**
 * Created by Shli on 25/07/2017.
 */
public class WordFrequency {
    private final String word;
    private int frequency = 0;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return this.word;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void addFrequency(int count) {
        this.frequency += count;
    }
}
