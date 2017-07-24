package io.genjitsu;

import io.genjitsu.fillers.FirstNameFiller;
import io.genjitsu.fillers.PropertyFiller;
import io.genjitsu.fillers.StringFiller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bcowdery on 6/28/2017.
 */
public class FillerManager {

    private Map<String, Map<String, PropertyFiller>> specificPropertyFillersByObjectType;
    private Map<Class, PropertyFiller> genericPropertyFillersByObjectType;
    private List<PropertyFiller> propertyFillers;

    public FillerManager() {
        reset();
    }

    // todo: I don't like this... makes testing filler "getByMember" logic pretty crappy
    public void reset() {
        if (propertyFillers == null) {
            propertyFillers = new ArrayList<>();

            // generics
            propertyFillers.add(new StringFiller());

            // property fillers
            propertyFillers.add(new FirstNameFiller());
        }
    }

    public <T> void resetType() {

    }

    public void register(PropertyFiller filler) {

    }

    public void remove(PropertyFiller filler) {

    }

    public void remove(Class type) {

    }

    /**
     * Returns the most appropriate filler for a java beans property name.
     * @param propertyName property name
     */
    public void getFillerForPropertyName(String propertyName) {

    }

}
