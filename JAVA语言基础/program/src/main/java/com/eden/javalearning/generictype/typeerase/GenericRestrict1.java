package com.eden.javalearning.generictype.typeerase;

public class GenericRestrict1<T> {

    private T data;

    /**
     * 不能实例化泛型类
     * Type parameter 'T' cannot be instantiated directly
     */
    public void setData() {
        //this.data = new T();
    }

    /**
     * 静态变量或方法不能引用泛型类型变量
     * GenericRestrict1.this cannot be referenced from a static context
     */
    // private static T staticdata;

//    public static void staticmethod(){
//        T tmp = data;
//    }

    /**
     * 静态泛型方法是可以的
     */
    private static <K> K getKey(K k) {
        return k;
    }


    public static void main(String[] args) {
        // 基本类型无法作为泛型类型
        // GenericRestrict1<int> tt= new GenericRestrict1<>();

        GenericRestrict1<Integer> t1= new GenericRestrict1<>();
        GenericRestrict1<String> t2= new GenericRestrict1<>();

        /**
         * 无法使用instanceof关键字判断泛型类的类型
         * Illegal generic type for instanceof
         */
//        if(t1 instanceof GenericRestrict1<Integer>){
//
//        }

        /**
         * 无法使用“==”判断两个泛型类的实例
         * Operator '==' cannot be applied to this two instance
         */
//        if( t1 == t2){
//
//        }
        if(t1 == t1){
            System.out.println(t1);
        }

        /**
         * 泛型数组可以声明但无法实例化
         * Generic array creation
         */
        GenericRestrict1<String>[] tarray;
        // tarray = new GenericRestrict1<String>[10];
        tarray = new GenericRestrict1[10];

    }
}
