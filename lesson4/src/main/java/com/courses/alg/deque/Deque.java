package com.courses.alg.deque;

import lombok.Getter;
import lombok.Setter;

public interface Deque<E> {

    void insertFirst(E value);

    void insertLast(E value);

    void remove(E value);

    E removeFirst();

    E removeLast();

    E peekFront();

    E peekLast();

    int size();

    boolean isEmpty();

    void display();

    @Getter
    @Setter
    class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
