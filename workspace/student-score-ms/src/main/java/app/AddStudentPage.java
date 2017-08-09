package app;

import service.StudentService;
import model.Student;
import util.Parser;

/**
 * Created by Shli on 30/07/2017.
 */
public class AddStudentPage extends Page {
    private boolean retry = false;

    @Override
    public String display() {
        return (retry ? AppMsg.PROMPT_ADD_STUDENT_RETRY : AppMsg.PROMPT_ADD_STUDENT);
    }

    @Override
    public String exec(String input) {
        Student student = Parser.parseStudent(input);

        if (student != null && StudentService.getInstance().addStudent(student)) {
            nextPage = new HomePage();
            return String.format(AppMsg.ALERT_ADD_STUDENT_SUCCESS, student.getName());
        } else {
            this.retry = true;
            return super.exec(input);
        }
    }
}
