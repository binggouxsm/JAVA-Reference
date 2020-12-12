package factory.simpleFactory;

import factory.bo.CPU;
import factory.bo.DragonCPU;
import factory.bo.IntelCPU;

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
