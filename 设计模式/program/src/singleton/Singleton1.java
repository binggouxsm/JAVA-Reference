package singleton;

public class Singleton1 {
    /* 声明变量为final 避免被修改。上来就初始化，类加载到内存后，保证实例化一个单例，JVM保证线程安全*/
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){
    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
