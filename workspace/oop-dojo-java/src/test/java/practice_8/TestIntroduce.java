package practice_8;

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
        Student tom = new Student("Tom", 21, new Klass(2));
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Student. I am at Class 2."));
    }

    @Test
    public void should_introduce_teacher() throws Exception {
        Teacher tom = new Teacher("Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Teacher. I teach No Class."));

        tom = new Teacher("Tom", 21, new Klass(2));
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. " +
                "I am a Teacher. I teach Class 2."));

    }

    @Test
    public void should_introduce_student_by_teacher() throws Exception {
        Teacher tom = new Teacher("Tom", 21, new Klass(2));

        assertThat(tom.introduceWith(new Student("Jerry", 18, new Klass(2))),
                is("My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry."));

        assertThat(tom.introduceWith(new Student("Jerry", 18, new Klass(1))),
                is("My name is Tom. I am 21 years old. I am a Teacher. I don't teach Jerry."));
    }
}
