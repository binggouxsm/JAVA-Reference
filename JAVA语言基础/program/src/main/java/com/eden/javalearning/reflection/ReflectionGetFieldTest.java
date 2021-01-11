package com.eden.javalearning.reflection;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ReflectionGetFieldTest {

    public static void main(String[] args) throws Exception {
        fieldprint();
        fieldsetget();
    }


    private static void fieldsetget() throws Exception{
        Bird swallow = new Bird("swallow", 1);
        Class clazz = swallow.getClass();
        Field fieldAge = clazz.getDeclaredField("age");
        // 访问私有变量，需设置Accessible
        fieldAge.setAccessible(true);
        System.out.println(fieldAge.getInt(swallow));
        fieldAge.setInt(swallow,3);
        System.out.println(swallow.getAge());


        Field fieldCat = clazz.getDeclaredField("category");
        fieldCat.setAccessible(true);
        System.out.println(fieldCat.get(swallow));
        // 故意设置类型不同的值，返回报错IllegalArgumentException
        fieldCat.set(swallow,new ArrayList<>());

    }

    private static void fieldprint(){
        Class clazz = Bird.class;
        // 获取所有的public变量
        Field[] fields = clazz.getFields();

        // 获取所有声明的变量（包括private）
        Field[] declaredFields = clazz.getDeclaredFields();

        for(Field field : declaredFields){
            StringBuffer sb = new StringBuffer();
            sb.append(" modifier : "+ Modifier.toString(field.getModifiers()));
            sb.append(" type = " + field.getType());
            sb.append(" Generic type = " + field.getGenericType().getTypeName());

            sb.append(" field name = " + field.getName());
            Annotation[] ann = field.getAnnotations();

            if(ann.length >0){
                sb.append(" annotation = ");
                for(Annotation a: ann){
                    sb.append(a.annotationType().getName());
                    sb.append(" , ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
