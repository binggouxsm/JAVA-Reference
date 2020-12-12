package factory.factoryMethod;

import factory.bo.CPU;
import factory.bo.DragonCPU;

public class DragonCPUFactory implements CPUFactory {
    @Override
    public CPU create() {
        return new DragonCPU();
    }
}
