package io.genjitsu.fillers;

/**
 * Created by bcowdery on 6/28/2017.
 */
public class StringFiller extends AbstractPropertyFiller<String> {

    public StringFiller() {
        super(new String[] { "object" },  new String[] { "*" }, true);
    }

    @Override
    public String getValue(Object instance) {
        return "Lorme Ipsum";
    }
}

