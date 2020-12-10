package singleton;

public class Singleton3 {
    private static Singleton3 INSTANCE;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if(INSTANCE == null){
            // 加入这段代码增加多线程下出错的概率
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 针对类对象上锁，避免对整个getInstance方法上锁，减少临界区
            synchronized (Singleton3.class){
                // 问题：虽然加了锁，但是前面的if判断仍然线程不安全，还是会导致初始化多次
                INSTANCE = new Singleton3();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                Singleton3 m = Singleton3.getInstance();
                System.out.println(m.hashCode());
            }).start();
        }
    }

}
