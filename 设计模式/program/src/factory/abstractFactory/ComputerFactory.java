package factory.abstractFactory;

import factory.bo.CPU;
import factory.bo.GPU;

public interface ComputerFactory {
    public CPU creatCPU();
    public GPU creatGPU();
}
