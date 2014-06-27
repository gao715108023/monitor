package com.gcj.test;

import com.gcj.dao.ServerMsgDao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by gaochuanjun on 14-6-4.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Class clazzProxy1 = Proxy.getProxyClass(ServerMsgDao.class.getClassLoader(), ServerMsgDao.class);
        System.out.println(clazzProxy1.getName());
        System.out.println("----构造方法列表----");
        Constructor[] constructors = clazzProxy1.getConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            Class[] clazzParames = constructor.getParameterTypes();
            for (Class clazzParame : clazzParames) {
                sb.append(clazzParame.getName()).append(",");
            }
            if (clazzParames.length != 0)
                sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            System.out.println(sb.toString());
        }
        System.out.println("----方法列表----");
        Method[] methods = clazzProxy1.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            Class[] clazzParames = method.getParameterTypes();
            for (Class clazzParame : clazzParames) {
                sb.append(clazzParame.getName()).append(",");
            }
            if (clazzParames.length != 0)
                sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            System.out.println(sb.toString());
        }
    }
}
