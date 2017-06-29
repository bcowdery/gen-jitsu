package io.genjitsu;

import io.genjitsu.models.Person;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static io.genjitsu.GenJitsu.*;

/**
 * Created by bcowdery on 6/28/2017.
 */
public class GenJitsuTest {

    @Test
    public void testGenJitsu_A_newInstance() {
        Person person = A.newInstance();
    }

    @Test
    public void testGenJitsu_A_listOf() {
        List<Person> people = A.listOf(1000);
    }

    @Test
    public void testGenJitsu_Configure() {
        GenJitsu.<Person>configure();
    }
}
