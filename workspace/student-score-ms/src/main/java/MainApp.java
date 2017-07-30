import app.App;
import app.AppMsg;

import java.util.Scanner;

/**
 * Created by Shli on 30/07/2017.
 */
public class MainApp {
    public static void run() {
        App app = new App();

        String msg = app.startup();
        System.out.print(msg);

        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine()) {
            msg = app.exec(reader.nextLine());
            if (msg.equals(AppMsg.SIG_EXIT)) {
                break;
            }
            System.out.print(msg);
        }
    }

    public static void main(String[] args) {
        MainApp.run();
    }
}
