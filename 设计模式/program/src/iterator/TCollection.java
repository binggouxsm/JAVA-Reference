package iterator;

public interface TCollection<E> {

    void add(E elem);

    TIterator<E> iterator();

}
