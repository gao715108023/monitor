package net.monitor.test;

import java.io.IOException;
import java.util.Hashtable;

/**
 * @author gaochuanjun
 * @since 14-6-4
 */
public class MyClassLoader extends ClassLoader {

    Hashtable loadedClasses;

    public MyClassLoader() {
        loadedClasses = new Hashtable();
    }

    public synchronized Class loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class newClass;
        byte[] classData;
        newClass = (Class) loadedClasses.get(className);
        if (newClass != null) {
            if (resolve)
                resolveClass(newClass);
            return newClass;
        }
        try {
            newClass = findSystemClass(className);
            return newClass;
        } catch (ClassNotFoundException e) {
            System.out.println(className + " is not a system class!");
        }

        try {
//用自定义方法载入类数据，存放于字节数组classData中。
            classData = getClassData(className);
//由字节数组所包含的数据建立一个class类型的对象。
            //newClass = defineClass(classData, 0, classData.length);
            // newClass=defineClass()
            if (newClass == null)
                throw new ClassNotFoundException(className);
        } catch (Exception e) {
            throw new ClassNotFoundException(className);
        }
        loadedClasses.put(className, newClass);
        if (resolve) {
            resolveClass(newClass);
        }
        return newClass;
    }

    protected byte[] getClassData(String className) throws IOException {
        return className.getBytes();
//        byte[] data;
//        int length;
//        InputStream inputStream = null;
//        try {
//            //从网络中采用URL类的方法载入指定URL地址的类的数据。
//            URL url = new URL(className.endsWith(".class") ? className : className + ".class");
//            URLConnection connection = url.openConnection();
//            inputStream = connection.getInputStream();
//            length = connection.getContentLength();
//            data = new byte[length];
//            inputStream.read(data);
//            return data;
//        } catch (Exception e) {
//            throw new IOException(className);
//        } finally {
//            if (inputStream != null) {
//                inputStream.close();
//            }
//        }
    }
}
