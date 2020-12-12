# Factory

## 作用

生成对象实例

有了new之后，为什么还需要工厂?
（1）构造过程比较复杂
（2）灵活控制生产过程，可以限制生成对象的权限，对对象修饰，增加日志

## 简单工厂

![简单工厂](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/SimpleFactory.png)

基础BO类
```java
public interface CPU {
    public void calc();
}
public class IntelCPU implements CPU {
    @Override
    public void calc() {
        System.out.println("IntelCPU calculating");
    }
}
public class DragonCPU implements CPU {
    @Override
    public void calc() {
        System.out.println("DragonCPU calculating");
    }
}
```

简单工厂
```java
/**
 * 简单工厂
 * 优点：通过传入不同的参数值，可以构建不同的类实例
 * 缺点：每次新增具体类时，都要修改工厂方法，扩展性差.
 */
public class SimpleCPUFactory {

    public CPU create(Class clazz){
        // 可以在工厂方法前增加统一的权限控制，日志等等
        if(clazz.equals(IntelCPU.class) ){
            return new IntelCPU();
        }
        else if(clazz.equals(DragonCPU.class)){
            return new DragonCPU();
        }
        return null;
    }
}
```

## 工厂方法

![工厂方法](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/FactoryMethod.png)

```java
public interface CPUFactory {
    public CPU create();
}

public class DragonCPUFactory implements CPUFactory {
    public CPU create() {
        return new DragonCPU();
    }
}

public class IntelCPUFactory implements CPUFactory {
    public CPU create() {
        return new IntelCPU();
    }
}

public class Main {
    public static void main(String[] args) {
        CPUFactory factory = new IntelCPUFactory();
        CPU cpu = factory.create();
        cpu.calc();

        CPUFactory factory1 = new DragonCPUFactory();
        CPU cpu1 = factory1.create();
        cpu1.calc();
    }
}
```
工厂方法相比简单工厂可扩展性更强。新增类型时，只需新增具体类及相应的具体工厂方法

## 抽象工厂

![抽象工厂](https://gitee.com/binggouxsm/JAVA-Reference/raw/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/pics/AbstractFactory.png)

基础BO类（增加）
```java
public interface GPU {
    public void display();
}
public class AGPU implements GPU {
    @Override
    public void display() {
        System.out.println("AMD display");
    }
}
public class NGPU implements GPU {
    @Override
    public void display() {
        System.out.println("NVIDIA display");
    }
}
```
```java
public interface ComputerFactory {
    public CPU creatCPU();
    public GPU creatGPU();
}
public class ForeignComputerFactory implements ComputerFactory {
    public CPU creatCPU() {
        return new IntelCPU();
    }
    public GPU creatGPU() {
        return new NGPU();
    }
}
public class ChinaComputerFactory implements ComputerFactory {
    public CPU creatCPU() {
        return new DragonCPU();
    }
    public GPU creatGPU() {
        return new AGPU();
    }
}
```

抽象工厂相比工厂方法，扩展维度不同，抽象工厂强调产品族群的扩展，工厂方法强调的是同一类型产品的扩展，一横一纵，有各自的使用场景



