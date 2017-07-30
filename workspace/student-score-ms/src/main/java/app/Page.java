package app;

/**
 * Created by Shli on 30/07/2017.
 */
public abstract class Page {
    private static final String MSG_EMPTY = "";

    protected Page nextPage = this;

    public abstract String display();

    public String exec(String input) {
        return MSG_EMPTY;
    }

    public Page next() {
        return nextPage;
    }
}
