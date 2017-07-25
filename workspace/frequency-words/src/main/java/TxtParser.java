import java.util.Arrays;
import java.util.List;

/**
 * Created by Shli on 25/07/2017.
 */
public class TxtParser {
    public TxtParser() {

    }

    public List<String> split(String txt) {
        return Arrays.asList(txt.trim().split("\\s+"));
    }
}
