package com.courses.alg.list.impl;

import com.courses.alg.list.DelinkedList;

public class SimpleDelinkedList<E> extends SimpleLinkedList<E> implements DelinkedList<E> {

    protected Node<E> lastNode;

    @Override
    public E getLast() {
        return lastNode.getItem();
    }

    @Override
    public void insertLast(E value) {
        size++;
        var newNode = new Node<>(value, null);
        lastNode.setNext(newNode);
        lastNode = newNode;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        var node = firstNode;
        Node<E> prevNode = null;
        while (node.getNext() != null) {
            prevNode = node;
            node = node.getNext();
        }

        var item = node.getItem();
        if (prevNode != null) {
            prevNode.setNext(null);
        } else {
            firstNode = null;
            lastNode = null;
        }

        size--;
        return item;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastNode = firstNode;
        }
    }
}
