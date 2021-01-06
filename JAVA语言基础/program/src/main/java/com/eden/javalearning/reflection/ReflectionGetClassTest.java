package com.eden.javalearning.reflection;

/**
 * 获取Class对象的方法
 */
public class ReflectionGetClassTest {

    public static void main(String[] args) throws Exception {
        // 对象实例，调用object.getClass()
        Class cl10 = new Bird().getClass();
        System.out.println(cl10.toString());

        Bird[] arr10 = new Bird[10];
        System.out.println(arr10.getClass());// 运行结果为 class [Lcom.eden.javalearning.reflection.Bird;

        double[] darr = new double[10];
        System.out.println(darr.getClass());// 运行结果为 class [D

        // 通过类的类型获取Class对象
        System.out.println(int.class.toString());
        System.out.println(Bird.class.toString());

        // 通过类的全限定名获取Class对象，基础类型无法使用此方法
        System.out.println(Class.forName("com.eden.javalearning.reflection.Swallow"));
        // 通过调用反射的相关方法获取Class对象
        System.out.println(Swallow.class.getSuperclass().toString());

    }
}
