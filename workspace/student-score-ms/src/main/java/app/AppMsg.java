package app;

/**
 * Created by Shli on 30/07/2017.
 */
public class AppMsg {
    public static final String EMPTY = "";

    public static final String PROMPT_MAIN_MENU =
            "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n";

    public static final String PROMPT_ADD_STUDENT =
            "请输入学生信息（格式：姓名，学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：\n";
    public static final String PROMPT_ADD_STUDENT_RETRY =
            "请按正确的格式输入（格式：姓名，学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：\n";
    public static final String ALERT_ADD_STUDENT_SUCCESS =
            "学生%s的成绩被添加\n";

    public static final String PROMPT_PRINT_REPORT =
            "请输入要打印的学生的学号（格式：学号，学号，...），按回车提交：\n";
    public static final String PROMPT_PRINT_REPORT_RETRY =
            "请按正确的格式输入要打印的学生的学号（格式：学号，学号，...），按回车提交：\n";

    public static final String SIG_EXIT = "exit";
}
