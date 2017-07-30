package app;

/**
 * Created by Shli on 30/07/2017.
 */
public class HomePage extends Page {
    private static final String MSG_MAIN_MENU =
            "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n";

    @Override
    public String display() {
        return MSG_MAIN_MENU;
    }

    @Override
    public String exec(String input) {
        if (input.equals("1")) {
            nextPage = new AddStudentPage();
        }

        return super.exec(input);
    }
}
