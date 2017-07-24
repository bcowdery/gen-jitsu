package io.genjitsu.utils;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Tests simple class utilities
 *
 * @author Brian Cowdery
 * @since 28-Jun-2017
 */
public class ClassUtilsTest {

    /**
     * Tests extraction property/field names from standard java bean getter
     * and setter naming patterns.
     */
    @Test
    public void testGetFieldName() {
        assertThat(ClassUtils.getFieldName("getSomeField"), is("someField"));
        assertThat(ClassUtils.getFieldName("setAnotherFieldName"), is("anotherFieldName"));
        assertThat(ClassUtils.getFieldName("getField"), is("field"));
    }
}
