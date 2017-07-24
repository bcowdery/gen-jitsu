package io.genjitsu.fillers;

public class FirstNameFiller extends AbstractPropertyFiller<String> {

    public FirstNameFiller() {
        super(new String[] { "object" }, new String[] { "firstName", "fname", "first_name" }, true);
    }

    @Override
    public Object getValue(Object instance) {
        return "Bob";
    }
}
