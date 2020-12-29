package com.eden.jvmlearning.classloader.initialtrigger;

interface TestInterface {

    int t = Main6.out("t",1);
    int b = Main6.out("b",2);

    default void aa(){
        System.out.println("aa method");
    }
}

class TestInterfaceImpl implements TestInterface {

    public void bb(){
        System.out.println("bb method");
    }
}

public class Main6 {

    public static void main(String[] args) {
        TestInterfaceImpl t = new TestInterfaceImpl();
        t.bb();
    }

    public static int out(String a, int i){
        System.out.println(a+"="+i);
        return i++;
    }
}
