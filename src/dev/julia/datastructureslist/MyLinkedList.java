package dev.julia.datastructureslist;


public class MyLinkedList<T> implements MyList<T> {

    private static class Node<T> {

        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
            this.next = null;
        }

        Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private static final int NOT_FOUND = -1;

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Índice " + index + " está fora do limite para tamanho " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element, head);
        head = newNode;

        if (size == 0) {
            tail = newNode;
        }

        size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element, null);

        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    @Override
    public void insertAt(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Índice " + index + " está fora do limite para tamanho " + size);
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<T> previousNode = getNode(index - 1);
            Node<T> newNode = new Node<>(element, previousNode.next);
            previousNode.next = newNode;
            size++;
        }
    }

    @Override
    public void addSorted(T element) {
        if (size == 0 || ((Comparable<T>) head.element).compareTo(element) >= 0) {
            addFirst(element);
            return;
        }

        if (((Comparable<T>) tail.element).compareTo(element) <= 0) {
            addLast(element);
            return;
        }

        Node<T> current = head;
        while (current.next != null
                && ((Comparable<T>) current.next.element).compareTo(element) < 0) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(element, current.next);
        current.next = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
          System.out.println("Não é possível remover de uma lista vazia.");
        }

        T removed = head.element;
        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return removed;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            System.out.println("Não é possível remover de uma lista vazia.");
        }

        if (size == 1) {
            return removeFirst();
        }

        Node<T> penultimate = getNode(size - 2);
        T removed = penultimate.next.element;

        penultimate.next = null;
        tail = penultimate;
        size--;

        return removed;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Índice " + index + " está fora do limite para tamanho " + size);
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<T> prev = getNode(index - 1);
        Node<T> target = prev.next;

        prev.next = target.next;
        target.next = null;
        size--;

        return target.element;
    }

    @Override
    public boolean remove(T element) {
        int index = find(element);

        if (index == NOT_FOUND) {
            return false;
        }

        removeAt(index);
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int find(T element) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.element.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return NOT_FOUND;
    }

    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    @Override
    public void set(int index, T element) {
        getNode(index).element = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.element);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
