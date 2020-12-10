package singleton;

public class Singleton2 {

    private static Singleton2 INSTANCE;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if(INSTANCE == null){
            // 加入这段代码增加线程被中断的可能性，更容易暴露多线程下出错的概率
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 两个线程判断INSTANCE都为空，都运行初始化，然后返回不同的实例对象
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                Singleton2 m = Singleton2.getInstance();
                System.out.println(m.hashCode());
            }).start();
        }
    }

}
