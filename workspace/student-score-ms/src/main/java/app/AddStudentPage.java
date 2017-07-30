package app;

/**
 * Created by Shli on 30/07/2017.
 */
public class AddStudentPage extends Page {
    private static final String MSG_ADD_STUDENT =
            "请输入学生信息（格式：姓名，学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提示：\n";

    @Override
    public String display() {
        return MSG_ADD_STUDENT;
    }

    @Override
    public String exec(String input) {
        return super.exec(input);
    }
}
