package factory.factoryMethod;

import factory.bo.CPU;

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
