package practice_1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Shli on 24/07/2017.
 */
public class TestPerson {

    @Test
    public void should_introduce_itself() throws Exception {
        Person tom = new Person("Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void should_exchange_name_directly() throws Exception {
        Person tom = new Person("Tom", 21);
        tom.name = "Tom Wu";
        assertThat(tom.toString(), is("My name is Tom Wu. I am 21 years old."));
    }
}
