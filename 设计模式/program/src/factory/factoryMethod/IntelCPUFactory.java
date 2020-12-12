package factory.factoryMethod;

import factory.bo.CPU;
import factory.bo.IntelCPU;

public class IntelCPUFactory implements CPUFactory {
    @Override
    public CPU create() {
        return new IntelCPU();
    }
}
