package com.eden.jvmlearning.classloader.initialtrigger;

import java.lang.reflect.InvocationTargetException;

/**
 * 使用java.lang.reflect包的方法第一次对类进行反射调用
 */
public class Main2 {
    public static void main(String[] args) {
        try {
            SubClass.class.getConstructor(null).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
