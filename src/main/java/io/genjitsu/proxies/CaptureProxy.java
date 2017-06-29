package io.genjitsu.proxies;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * Capturing proxy that reports the last method invoked on the proxied object.
 *
 * @author Brian Cowdery
 * @since 28-Jul-2017
 */
public class CaptureProxy<T> {

    private T object;
    private MethodCaptureInterceptor interceptor;

    /* private */
    private CaptureProxy(T object, MethodCaptureInterceptor recorder) {
        this.object = object;
        this.interceptor = recorder;
    }

    /**
     * Creates an proxy that captures invoked methods.
     *
     * @param clazz class to proxy
     * @param <T> proxy type
     * @return capturing proxy instance
     */
    @SuppressWarnings("unchecked")
    public static <T> CaptureProxy<T> create(Class<T> clazz) {
        final MethodCaptureInterceptor interceptor = new MethodCaptureInterceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(interceptor);

        return new CaptureProxy(enhancer.create(), interceptor);
    }

    /**
     * Returns the last method invoked on the proxied object.
     * @return invoked method or null
     */
    public Method getInvokedMethod() {
        return interceptor.getInvokedMethod();
    }

    /**
     * Returns proxy object.
     * @return object
     */
    public T getObject() {
        return object;
    }
}
