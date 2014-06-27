package com.gcj.test;

/**
 * Created by gaochuanjun on 14-6-4.
 */
public class TestClassLoader {
    public static void main(String[] args) {
        MyClassLoader ll = new MyClassLoader();
        Class cc;
        Object oo;
        String ss = "Tested.class";

        if (args.length != 0) ss = args[0];
        try {
            System.out.println("Loading class " + ss + "...");
//使用重写的方法loadClass()载入类数据。
            cc = ll.loadClass(ss);
            System.out.println("Creat instance...");
//创建Object类型的类实例。
            oo = cc.newInstance();
            System.out.println("Call start() method...");
//强制类型转换并执行被载入类中的方法。
            ((Share) oo).start(args);
        } catch (Exception e) {

            System.out.println("Caught exception : " + e);
        }
    }
}
