package practice_13;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 24/07/2017.
 */
public class TestIntroduce {

    private Student jane = new Student("101", "Jane", 19);
    private Student peter = new Student("201", "Peter", 18);
    private Student jim = new Student("202", "Jim", 19);

    private Teacher tom = new Teacher("001", "Tom", 21);

    private final ByteArrayOutputStream consoleLog = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        KlassManager.getManager().createKlass(1);
        KlassManager.getManager().createKlass(2);
        KlassManager.getManager().createKlass(3);

        KlassManager.getManager().getKlass(1).appendMember(jane);
        KlassManager.getManager().getKlass(2).appendMember(peter);
        KlassManager.getManager().getKlass(2).appendMember(jim);

        KlassManager.getManager().getKlass(2).appendTeacher(tom);
        KlassManager.getManager().getKlass(3).appendTeacher(tom);

        System.setOut(new PrintStream(consoleLog));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void should_introduce_person() throws Exception {
        Person per = new Person("001", "Tom", 21);
        assertThat(per.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void should_introduce_student() throws Exception {
        assertThat(peter.introduce(), is("My name is Peter. I am 18 years old. " +
                "I am a Student. I am at Class 2."));
    }

    @Test
    public void should_introduce_for_class_leader() throws Exception {
        consoleLog.reset();
        KlassManager.getManager().getKlass(2).assignLeader(jane);
        assertThat(consoleLog.toString(), is("It is not one of us."));
        assertThat(jane.introduce(), is("My name is Jane. I am 19 years old. " +
                "I am a Student. I am at Class 1."));

        KlassManager.getManager().getKlass(2).assignLeader(jim);
        assertThat(jim.introduce(), is("My name is Jim. I am 19 years old. " +
                "I am a Student. I am Leader of Class 2."));
    }

    @Test
    public void should_introduce_teacher() throws Exception {
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Teacher. I teach Class 2, 3."));

        assertThat(new Teacher("003", "Kitty", 20).introduce(),
                is("My name is Kitty. I am 20 years old. " +
                        "I am a Teacher. I teach No Class."));
    }

    @Test
    public void should_notify_teacher_for_class_news() throws Exception {
        KlassManager.getManager().getKlass(2).addListener(tom);

        Student jerry = new Student("203", "Jerry", 18);

        consoleLog.reset();
        KlassManager.getManager().getKlass(2).appendMember(jerry);
        assertThat(consoleLog.toString(), is("I am Tom. " +
                "I know Jerry has joined Class 2."));

        consoleLog.reset();
        KlassManager.getManager().getKlass(2).assignLeader(jerry);
        assertThat(consoleLog.toString(), is("I am Tom. " +
                "I know Jerry become Leader of Class 2."));
    }

    @Test
    public void should_notify_teacher_and_computer_for_class_news() throws Exception {
        Computer computer = new Computer("Puter");
        KlassManager.getManager().getKlass(1).addListener(computer);

        Student tony = new Student("204", "Tony", 18);

        consoleLog.reset();
        KlassManager.getManager().getKlass(1).appendMember(tony);
        assertThat(consoleLog.toString(), is(
                "I am the Machine. I know Tony has joined Class 1."));


        consoleLog.reset();
        KlassManager.getManager().getKlass(1).assignLeader(tony);
        assertThat(consoleLog.toString(), is(
                "I am the Machine. I know Tony become Leader of Class 1."));
    }
}
