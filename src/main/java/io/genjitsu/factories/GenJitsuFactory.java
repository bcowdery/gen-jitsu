package io.genjitsu.factories;

import io.genjitsu.exceptions.GenJitsuReflectionException;

import java.lang.reflect.ParameterizedType;

/**
 * Simple object factory for constructing instances of type <T>
 *
 * @author Brian Cowdery
 * @since 28-Jun-2017
 */
@SuppressWarnings("unchecked")
public class GenJitsuFactory<T> {

    private Class<T> objectClass;

    public GenJitsuFactory() {
        this.objectClass
                = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T createInstance() {
        try {
            return objectClass.newInstance();
        } catch (InstantiationException e) {
            throw new GenJitsuReflectionException("Could not instantiate object of type " + objectClass, e);
        } catch (IllegalAccessException e) {
            throw new GenJitsuReflectionException("Illegal access for type" + objectClass, e);
        }
    }
}
