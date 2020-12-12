package factory.bo;

public class DragonCPU implements CPU {
    @Override
    public void calc() {
        System.out.println("DragonCPU calculating");
    }
}
