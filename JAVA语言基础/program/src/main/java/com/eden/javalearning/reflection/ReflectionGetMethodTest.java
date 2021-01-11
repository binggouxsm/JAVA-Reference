package com.eden.javalearning.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionGetMethodTest {

    public static void main(String[] args) throws Exception {
//        constructorprint();
        methodInvoke();

    }

    private static void methodInvoke() throws Exception {
        Class clazz = Bird.class;
        Object bird = clazz.getConstructor(null).newInstance();

        Method method = clazz.getDeclaredMethod("fly", int.class);
        method.invoke(bird,5);

        // 可变参数方法的调用
        Object varArgs = new String[]{"asd","vvvvv","asdasd"};
        Method varargsMethod = clazz.getDeclaredMethod("setNicknameVarArg", String[].class);
        // varArgs必须是Object类型，否则会报错 wrong number of arguments
        varargsMethod.invoke(bird,varArgs);

        System.out.println(((Bird)bird).getNickname());



    }

    private static void constructorprint(){
        Class clazz = Bird.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors){
            StringBuffer sb = new StringBuffer();
            sb.append(" modifiers "+ Modifier.toString(constructor.getModifiers()));
            sb.append(" name "+ constructor.getName());

            Parameter[] parameters = constructor.getParameters();
            sb.append(parameterprint(parameters));
            System.out.println(sb.toString());

        }
    }


    private static StringBuffer parameterprint(Parameter[] parameters){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < parameters.length; i++) {
            sb.append(" parameter["+ i +"]: ");
            sb.append(parameters[i].getType()+" ");
            //获取参数名称，如果编译时未加上`-parameters`，返回的名称形如`argX`, X为参数在方法声明中的位置，从0开始
            sb.append(parameters[i].getName()+" ");
            // 判断是否为可变参数
            sb.append(parameters[i].isVarArgs()+" ");

        }
        return sb;
    }


    private static void methodprint(){
        Class clazz = Bird.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method method: declaredMethods){
            StringBuffer sb = new StringBuffer();
            sb.append(" modifiers "+ Modifier.toString(method.getModifiers()));

            sb.append(" returnType "+ method.getReturnType().toString());
            sb.append(" GenericReturnType "+ method.getGenericReturnType());

            sb.append(" name "+ method.getName());

            Parameter[] parameters = method.getParameters();
            sb.append(parameterprint(parameters));
            System.out.println(sb.toString());
        }

    }
}
