package state;

/**
 * Created by Shli on 27/07/2017.
 */
public class PageState {
    public static final int PAGE_HOME = 0;
    public static final int PAGE_ADD_STUDENT = 1;
    public static final int PAGE_PRINT_REPORT = 2;
    public static final int PAGE_EXIT = 3;

    private int page = PAGE_HOME;

    public int getPage() {
        return page;
    }

    public void input(String data) {
        if (data.equals("1")) {
            page = PAGE_ADD_STUDENT;
        } else if (data.equals("2")) {
            page = PAGE_PRINT_REPORT;
        } else if (data.equals("3")) {
            page = PAGE_EXIT;
        }
    }
}
