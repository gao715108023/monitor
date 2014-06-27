package com.gcj.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.gcj.bean.Info;

public class BeanUtil {

    public static void copyProperties(Object obj1, Object obj2) throws Exception {
        Class classTypeF = obj1.getClass();
        Class classTypeS = obj2.getClass();
        Field fieldsF[] = classTypeF.getDeclaredFields();

        for (Field field : fieldsF) {
            String propertyName = field.getName();

            // 验证对象2是否包含此属性
            boolean isHas = true;
            try {
                // 验证该属性在受复制对象中是否存在
                classTypeS.getDeclaredField(propertyName);
            } catch (Exception e) {
                isHas = false;
            }

            // 判断两个对象是否包含该属性
            if (isHas) {
                // 获取对应的set,get方法名称
                String prefix = propertyName.substring(0, 1).toUpperCase();
                String getMethodName = "get" + prefix + propertyName.substring(1);
                String setMethodName = "set" + prefix + propertyName.substring(1);

                // 获取对应的方法
                Method methodGet = classTypeF.getMethod(getMethodName, new Class[]{});
                Method methodSet = classTypeS.getMethod(setMethodName, new Class[]{field.getType()});

                Object objValue = methodGet.invoke(obj1);
                String methodGetValue = objValue == null ? "" : objValue.toString();

                // copy对应的值(这个地方可以根据需求而改变)
                methodSet.invoke(obj2, methodGetValue.trim());
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Info info = new Info();

    }
}
