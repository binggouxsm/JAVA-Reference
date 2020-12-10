package singleton;

public class Singleton5 {

    private Singleton5(){}

    // 加载外部类时，不会加载内部类, 从而实现懒加载
    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
