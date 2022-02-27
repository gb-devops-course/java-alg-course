package com.courses.alg.list;

public interface DelinkedList<E> extends LinkedList<E> {

    E getLast();

    void insertLast(E value);

    E removeLast();
}
