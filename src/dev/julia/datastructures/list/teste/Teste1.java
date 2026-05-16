package dev.julia.datastructures.list.teste;

import dev.julia.datastructureslist.MyLinkedList;

public class Teste1 {
    public static void main(String[] args) {

        MyLinkedList<Integer> lista = new MyLinkedList<>();

        System.out.println("=== TESTE DA LISTA ENCADEADA ===");

        // Teste isEmpty
        System.out.println("\nLista está vazia? " + lista.isEmpty());

        // addFirst
        lista.addFirst(10);
        lista.addFirst(5);
        lista.addFirst(1);

        System.out.println("\nApós addFirst:");
        System.out.println(lista);

        // addLast
        lista.addLast(20);
        lista.addLast(30);

        System.out.println("\nApós addLast:");
        System.out.println(lista);

        // insertAt
        lista.insertAt(2, 99);

        System.out.println("\nApós insertAt(2, 99):");
        System.out.println(lista);

        // addSorted
        MyLinkedList<Integer> ordenada = new MyLinkedList<>();

        ordenada.addSorted(20);
        ordenada.addSorted(10);
        ordenada.addSorted(30);
        ordenada.addSorted(25);
        ordenada.addSorted(5);

        System.out.println("\nLista ordenada com addSorted:");
        System.out.println(ordenada);

        // get
        System.out.println("\nElemento no índice 3:");
        System.out.println(lista.get(3));

        // set
        lista.set(3, 777);

        System.out.println("\nApós set(3, 777):");
        System.out.println(lista);

        // find
        System.out.println("\nÍndice do elemento 20:");
        System.out.println(lista.find(20));

        // size
        System.out.println("\nTamanho da lista:");
        System.out.println(lista.size());

        // removeFirst
        System.out.println("\nRemovido do início:");
        System.out.println(lista.removeFirst());

        System.out.println("Lista após removeFirst:");
        System.out.println(lista);

        // removeLast
        System.out.println("\nRemovido do final:");
        System.out.println(lista.removeLast());

        System.out.println("Lista após removeLast:");
        System.out.println(lista);

        // removeAt
        System.out.println("\nRemovido do índice 1:");
        System.out.println(lista.removeAt(1));

        System.out.println("Lista após removeAt:");
        System.out.println(lista);

        // remove(element)
        System.out.println("\nRemove elemento 777:");
        System.out.println(lista.remove(777));

        System.out.println("Lista após remove(777):");
        System.out.println(lista);

        // clear
        lista.clear();

        System.out.println("\nApós clear:");
        System.out.println(lista);

        // isEmpty novamente
        System.out.println("\nLista está vazia? " + lista.isEmpty());
    }
}
