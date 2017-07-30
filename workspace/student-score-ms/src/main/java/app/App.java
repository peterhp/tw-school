package app;

/**
 * Created by Shli on 30/07/2017.
 */
public class App {
    private Page page;

    public String startup() {
        page = new HomePage();
        return page.run();
    }
}
