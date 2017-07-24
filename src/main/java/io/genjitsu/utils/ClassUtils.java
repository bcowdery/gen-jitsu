package io.genjitsu.utils;

/**
 * Created by bcowdery on 6/28/2017.
 */
public class ClassUtils {

    /**
     * Converts a method name to a javabeans field name.
     *
     * @param methodName method name
     * @return field name
     */
    public static String getFieldName(String methodName) {
        return methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
    }
}
