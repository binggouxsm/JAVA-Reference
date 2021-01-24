package iterator;

public class TArrayList<E> implements TCollection<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object elements[];

    private int size;

    public  TArrayList(){
        elements = new Object[DEFAULT_CAPACITY];

    }

    @Override
    public void add(E elem) {

    }

    @Override
    public TIterator<E> iterator() {
        return null;
    }
}
