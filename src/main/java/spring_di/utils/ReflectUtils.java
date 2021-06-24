package spring_di.utils;

import spring_di.TransactionInfo;
import spring_di.enums.CustomerType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class ReflectUtils {

    private ReflectUtils() {
    }

    public static Method getMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> Object methodInvoke(Map<CustomerType, T> map, Method method, Object... args) {
        try {
            return method.invoke(map.get(TransactionInfo.getCustomerType()), args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> T newProxy(Class<T> clazz, Map<CustomerType, T> map) {
        var object = Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz},
                (proxy, method, args) -> method.invoke(map.get(TransactionInfo.getCustomerType()), args));
        return clazz.cast(object);
    }

}
