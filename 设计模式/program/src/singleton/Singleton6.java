package singleton;

public enum Singleton6 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                Singleton6 m = Singleton6.INSTANCE;
                System.out.println(m.hashCode());
            }).start();
        }
    }
}
