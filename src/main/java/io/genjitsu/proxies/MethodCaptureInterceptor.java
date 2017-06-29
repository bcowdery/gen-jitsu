package io.genjitsu.proxies;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Proxy {@link Enhancer} callback which provides "around advice" for invoked methods,
 * capturing the last method invocation to aid in discovery of methods hidden in lambda
 * and Member reference expressions.
 *
 * @author Brian Cowdery
 * @since 28-Jun-2017
 */
public class MethodCaptureInterceptor implements MethodInterceptor {

    private Method invokedMethod = null;

    /**
     * Returns the invoked method.
     * @return method
     */
    public Method getInvokedMethod() {
        return invokedMethod;
    }

    /**
     * All generated proxied methods call this method instead of the original method.
     * The original method may either be invoked by normal reflection using the Method object,
     * or by using the MethodProxy (faster).
     *
     * @param obj "this", the enhanced object
     * @param method intercepted Method
     * @param args argument array; primitive types are wrapped
     * @param proxy used to invoke super (non-intercepted method); may be called as many times as needed
     * @throws Throwable any exception may be thrown; if so, super method will not be invoked
     * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
     * @see MethodProxy
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        this.invokedMethod = method;


        return proxy.invokeSuper(obj, args);
    }
}
