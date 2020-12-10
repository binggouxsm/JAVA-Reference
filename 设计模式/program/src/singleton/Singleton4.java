package singleton;

public class Singleton4 {
    private static volatile Singleton4 INSTANCE;

    private Singleton4(){}

    public static Singleton4 getInstance(){
        if(INSTANCE == null){
            // 加入这段代码增加多线程下出错的概率
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 针对类对象上锁，避免对整个getInstance方法上锁，减少临界区
            synchronized (Singleton4.class){
                // 两次判断INSTANCE == null
                if(INSTANCE == null){
                    INSTANCE = new Singleton4();
                }

            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                Singleton4 m = Singleton4.getInstance();
                System.out.println(m.hashCode());
            }).start();
        }
    }

}
