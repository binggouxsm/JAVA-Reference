package factory.simpleFactory;

import factory.bo.CPU;
import factory.bo.DragonCPU;
import factory.bo.IntelCPU;

/**
 * 简单工厂
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
