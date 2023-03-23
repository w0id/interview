package hw2;

public interface List<E> extends Iterable<E> {

    int size();

    boolean add(E element);

    void remove(E element);

    void remove(int index);

    E get(int index);

    int indexOf(E element);

}