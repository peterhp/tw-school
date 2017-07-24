package practice_13;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 24/07/2017.
 */
public class TestIntroduce {

    private Student peter = new Student("201", "Peter", 18);

    @Before
    public void setUp() throws Exception {
        Klass class2 = KlassManager.getManager().createKlass(2);
        class2.appendMember(peter);
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
}
