package factory.simpleFactory;

import factory.bo.CPU;
import factory.bo.DragonCPU;
import factory.bo.IntelCPU;

public class Main {

    public static void main(String[] args) {
        SimpleCPUFactory factory = new SimpleCPUFactory();
        CPU cpu = factory.create(IntelCPU.class);
        cpu.calc();

        CPU cpu1 = factory.create(DragonCPU.class);
        cpu1.calc();


    }
}
