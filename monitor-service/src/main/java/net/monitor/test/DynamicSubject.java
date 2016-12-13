package net.monitor.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author gaochuanjun
 * @since 14-6-4
 */
public class DynamicSubject implements InvocationHandler {
    private Object sub;

    public DynamicSubject() {
    }

    public DynamicSubject(Object obj) {
        sub = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(sub, args);
        return null;
    }
}
