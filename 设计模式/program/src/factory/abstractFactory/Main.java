package factory.abstractFactory;

import factory.bo.CPU;
import factory.bo.GPU;

public class Main {
    public static void main(String[] args) {
        ComputerFactory factory = new ChinaComputerFactory();
        CPU cpu = factory.creatCPU();
        GPU gpu = factory.creatGPU();

    }
}
