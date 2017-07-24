package practice_4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 24/07/2017.
 */
public class TestIntroduce {
    @Test
    public void should_introduce_person() throws Exception {
        Person tom = new Person("Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void should_introduce_student() throws Exception {
        Student tom = new Student("Tom", 21, 2);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Student. I am at Class 2."));
    }
}
