package mediator;

public abstract class Mediator {

    public abstract void register(Colleague c);

    public abstract void unregister(Colleague c);

    /**
     * 转发
     * @param
     */
    public abstract void relay(Colleague from, String msg);

}
