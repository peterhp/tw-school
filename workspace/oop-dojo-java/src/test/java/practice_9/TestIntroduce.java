package practice_9;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 25/07/2017.
 */
public class TestIntroduce {
    @Test
    public void should_introduce_person() throws Exception {
        Person per = new Person("P001","Tom", 21);
        assertThat(per.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void should_introduce_student() throws Exception {
        Klass klass2 = new Klass(2);
        Student stu = new Student("S001", "Tom", 21, klass2);

        assertThat(stu.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Student. I am at Class 2."));

        klass2.assignLeader(stu);
        assertThat(stu.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Student. I am Leader of Class 2."));
    }

    @Test
    public void should_introduce_teacher() throws Exception {
        Teacher teacher1 = new Teacher("T001", "Tom", 21, new Klass(2));
        assertThat(teacher1.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Teacher. I teach Class 2."));

        Teacher teacher2 = new Teacher("T002", "Tom", 21);
        assertThat(teacher2.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Teacher. I teach No Class."));
    }
}
