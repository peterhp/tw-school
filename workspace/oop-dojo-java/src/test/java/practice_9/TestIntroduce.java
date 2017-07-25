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
}
