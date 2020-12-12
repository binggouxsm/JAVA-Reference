package factory.bo;

public class IntelCPU implements CPU {
    @Override
    public void calc() {
        System.out.println("IntelCPU calculating");
    }
}
