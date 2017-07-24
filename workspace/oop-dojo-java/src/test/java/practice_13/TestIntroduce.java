package practice_13;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 24/07/2017.
 */
public class TestIntroduce {

    private Student jane = new Student("101", "Jane", 19);
    private Student peter = new Student("201", "Peter", 18);
    private Student jim = new Student("202", "Jim", 19);

    @Before
    public void setUp() throws Exception {
        KlassManager.getManager().createKlass(1);
        KlassManager.getManager().createKlass(2);

        KlassManager.getManager().getKlass(1).appendMember(jane);
        KlassManager.getManager().getKlass(2).appendMember(peter);
        KlassManager.getManager().getKlass(2).appendMember(jim);
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
        KlassManager.getManager().getKlass(2).assignLeader(jane);
        assertThat(jane.introduce(), is("My name is Jane. I am 19 years old. " +
                "I am a Student. I am at Class 1."));

        KlassManager.getManager().getKlass(2).assignLeader(jim);
        assertThat(jim.introduce(), is("My name is Jim. I am 19 years old. " +
                "I am a Student. I am Leader of Class 2."));
    }
}
