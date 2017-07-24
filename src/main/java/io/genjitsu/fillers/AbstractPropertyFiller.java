package io.genjitsu.fillers;

import java.lang.reflect.ParameterizedType;

/**
 * Base class for simple property fillers
 *
 * @author Brian Cowdery
 * @since 28-Jun-2017
 */
public abstract class AbstractPropertyFiller<T> implements PropertyFiller {

    private String[] propertyNames;
    private String[] objectTypeNames;
    private boolean isGenericFiller;
    private Class<T> propertyType;

    protected AbstractPropertyFiller(String[] objectTypeNames, String[] propertyNames) {
        this(objectTypeNames, propertyNames, false);
    }

    protected AbstractPropertyFiller(String[] propertyNames, String[] objectTypeNames, boolean isGenericFiller) {
        this.propertyNames = propertyNames;
        this.objectTypeNames = objectTypeNames;
        this.isGenericFiller = isGenericFiller;
    }

    @Override
    public String[] getPropertyNames() {
        return this.objectTypeNames;
    }

    @Override
    public String[] getObjectTypeNames() {
        return this.objectTypeNames;
    }

    @Override
    public boolean isGenericFiller() {
        return this.isGenericFiller;
    }

    @Override
    public Class<T> propertyType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public abstract T getValue(Object instance);
}
