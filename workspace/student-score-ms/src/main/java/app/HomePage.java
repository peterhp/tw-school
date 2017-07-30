package app;

/**
 * Created by Shli on 30/07/2017.
 */
public class HomePage extends Page {
    private static final String CMD_ADD_STUDENT = "1";
    private static final String CMD_PRINT_REPORT = "2";

    @Override
    public String display() {
        return AppMsg.PROMPT_MAIN_MENU;
    }

    @Override
    public String exec(String input) {
        switch (input) {
            case CMD_ADD_STUDENT:
                nextPage = new AddStudentPage();
                break;

            case CMD_PRINT_REPORT:
                nextPage = new PrintReportPage();
                break;
        }

        return super.exec(input);
    }
}
