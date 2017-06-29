package io.genjitsu;

import io.genjitsu.models.Person;
import io.genjitsu.proxies.CaptureProxy;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Tests capturing of the last invoked method via cglib proxy
 */
public class CaptureProxyTest {

    /**
     * Tests that the proxied object type resolves to that of the original class
     * and that the invoked method is null in it's default state.
     */
    @Test
    public void testDefault() {
        CaptureProxy<Person> proxy = CaptureProxy.create(Person.class);

        assertThat(proxy.getObject(), isA(Person.class));
        assertThat(proxy.getInvokedMethod(), nullValue());
    }

    /**
     * Tests that invoking a getter method on the proxied instance
     * captures the invoked method.
     */
    @Test
    public void testGetInvokedMethod_getter() {
        CaptureProxy<Person> proxy = CaptureProxy.create(Person.class);

        // invoke
        proxy.getObject().getFirstName();

        // verify
        Method method = proxy.getInvokedMethod();
        assertThat(method.getName(), equalTo("getFirstName"));
    }

    /**
     * Tests that invoking a getter on the proxied object via lambda
     * expression captures the method name.
     */
    @Test
    public void testGetInvokedMethod_getter_lambda() {
        CaptureProxy<Person> proxy = CaptureProxy.create(Person.class);

        // invoke lambda
        invoke(proxy.getObject(), p -> p.getFirstName());

        // verify
        Method method = proxy.getInvokedMethod();
        assertThat(method.getName(), equalTo("getFirstName"));
    }

    /**
     * Tests that invoking a getter on the proxied object via method expression
     * captures the method name.
     */
    @Test
    public void testGetInvokedMethod_getter_methodref() {
        CaptureProxy<Person> proxy = CaptureProxy.create(Person.class);

        // invoke method ref
        invoke(proxy.getObject(), Person::getFirstName);

        // verify
        Method method = proxy.getInvokedMethod();
        assertThat(method.getName(), equalTo("getFirstName"));
    }

    /**
     * Invoke a lambda function or method reference on an object.
     * @param obj object
     * @param func function to invoke
     */
    private <T> void invoke(T obj, Function<T, ?> func) {
        func.apply(obj);
    }
}
