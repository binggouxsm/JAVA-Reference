package facade;

public class Facade {
    private SubSystem01 sub01 = new SubSystem01();
    private SubSystem02 sub02 = new SubSystem02();
    private SubSystem03 sub03 = new SubSystem03();

    public void method(){
        sub01.method01();
        sub02.method02();
        sub03.method03();
    }
}
