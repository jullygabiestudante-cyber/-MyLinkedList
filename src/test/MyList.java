package test;

public interface MyList<T> {

    void addFirst(T element);

    void addLast(T element);

    void insertAt(int index, T element);

    void addSorted(T element);

    T removeFirst();

    T removeLast();

    T removeAt(int index);

    boolean remove(T element);

    void clear();

    int find(T element);

    T get(int index);

    void set(int index, T element);

    int size();
}

