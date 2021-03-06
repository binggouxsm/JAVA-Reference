# Singleton

## 作用
生成内存中唯一的实例

## 实现

### 实现1：饿汉式

```java
public class Singleton1 {
    /* 声明变量为final 避免被修改。上来就初始化，类加载到内存后，保证实例化一个单例，JVM保证线程安全*/
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){
    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
```

优点：实现简单
缺点：类没有被使用，就已经初始化


### 实现2：懒汉式

```java
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
```

问题：两个线程判断INSTANCE都为空，都运行初始化，然后返回不同的实例对象
解决方法：加锁synchronized同步机制。synchronized如果加在整个getInstance上，虽然保证线程安全，但是并发效率下降的厉害。需要锁细化，只针对初始化时进行类对象上锁

```java
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
                // 问题：虽然加了锁，但是前面的if判断仍然线程不安全，还是会导致初始化多次，只是初始化的顺序执行多次
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
```

#### DCL(Double-Checked Lock)

```java
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
```

衍生面试题：DCL是否要用volatile?
要，new Singleton4() 不是原子的，分为开辟内存，初始化对象的变量，引用指针指向内存两个指令，由于指令重排，很低概率导致初始化对象的变量，引用指针指向内存 这两个指令颠倒顺序，导致 其他线程可以访问到 未完成初始化的变量值。 volatile避免指令重排

### 实现3：静态内部类

```java
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
```

### 实现4：枚举单例

Effective Java中单例写法，不仅可以解决线程安全，还可以防止反序列化

```java
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
```






