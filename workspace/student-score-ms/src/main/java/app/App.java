package app;

/**
 * Created by Shli on 30/07/2017.
 */
public class App {
    private Page page;

    public String startup() {
        page = new HomePage();
        return page.display();
    }

    public String exec(String input) {
        String msg = page.exec(input);

        page = page.next();
        msg += page.display();

        return msg;
    }
}
