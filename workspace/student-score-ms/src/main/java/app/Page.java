package app;

/**
 * Created by Shli on 30/07/2017.
 */
public abstract class Page {
    protected Page nextPage = this;

    public abstract String display();

    public String exec(String input) {
        return AppMsg.EMPTY;
    }

    public Page next() {
        return nextPage;
    }
}
