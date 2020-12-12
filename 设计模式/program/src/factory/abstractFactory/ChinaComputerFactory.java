package factory.abstractFactory;

import factory.bo.AGPU;
import factory.bo.CPU;
import factory.bo.DragonCPU;
import factory.bo.GPU;

public class ChinaComputerFactory implements ComputerFactory {
    @Override
    public CPU creatCPU() {
        return new DragonCPU();
    }

    @Override
    public GPU creatGPU() {
        return new AGPU();
    }
}
