import java.io.*;

/**
 * Created by Shli on 25/07/2017.
 */
public class TxtReader {
    public String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line = reader.readLine();
            while (line != null) {
                content.append(line);
                content.append("\n");

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
}
