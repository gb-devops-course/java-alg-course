package com.courses.alg.list;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.function.Consumer;

public interface LinkedList<E> extends Iterable<E> {

    E getFirst();

    void insertFirst(E value);

    void insert(int index, E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    @Getter
    @Setter
    class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
