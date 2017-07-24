package practice_1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 24/07/2017.
 */
public class TestPerson {

    private Person tom = new Person("Tom", 21);

    @Test
    public void should_introduce_itself() throws Exception {
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old."));
    }
}
