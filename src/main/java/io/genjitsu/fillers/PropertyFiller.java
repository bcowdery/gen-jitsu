package io.genjitsu.fillers;

/**
 * Interface for property fillers
 */
public interface PropertyFiller<T> {

    /**
     * Property names that this filler applies to.
     *
     * @return array of applicable property names, "*" wildcard for any name.
     */
    String[] getPropertyNames();

    /**
     * Class names that this filler applies to.
     * Use "Object" for generic fillers that can be applied to all object types.
     *
     * @return array of applicable object type names.
     */
    String[] getObjectTypeNames();

    /**
     * If filler is generic and is applied based on {@link #propertyType()} and not
     * matching property names.
     *
     * @return true if filter is generic, false if must match against property name.
     */
    boolean isGenericFiller();

    /**
     * Type of the field this filler is generating a value for.
     *
     * @return property type
     */
    Class<T> propertyType();

    /**
     * Generates a value.
     *
     * @param instance object instance tha the value is being generated for.
     * @return generated value
     */
    T getValue(Object instance);

}
