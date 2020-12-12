package factory.abstractFactory;

import factory.bo.CPU;
import factory.bo.GPU;
import factory.bo.IntelCPU;
import factory.bo.NGPU;

public class ForeignComputerFactory implements ComputerFactory {
    @Override
    public CPU creatCPU() {
        return new IntelCPU();
    }

    @Override
    public GPU creatGPU() {
        return new NGPU();
    }
}
