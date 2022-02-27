package com.courses.alg.list.impl;

import com.courses.alg.list.LinkedList;
import lombok.AllArgsConstructor;

import java.util.Iterator;

public class SimpleLinkedList<E> implements LinkedList<E> {

    protected Node<E> firstNode;
    protected int size;

    public SimpleLinkedList() {
        this.size = 0;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return firstNode.getItem();
    }

    @Override
    public void insertFirst(E value) {
        size++;
        firstNode = new Node<>(value, firstNode);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        var item = firstNode.getItem();
        firstNode = firstNode.getNext();
        size--;
        return item;
    }

    @Override
    public boolean remove(E value) {
        if (isEmpty()) {
            return false;
        }

        if (firstNode.getItem().equals(value)) {
            firstNode = firstNode.getNext();
            size--;
            return true;
        }

        var node = firstNode.getNext();
        var prevNode = firstNode;
        while (node != null) {
            if (node.getItem().equals(value)) {
                prevNode.setNext(node.getNext());
                size--;
                return true;
            }
            prevNode = node;
            node = node.getNext();
        }

        return false;
    }

    @Override
    public boolean contains(E value) {
        var node = firstNode;
        while (node != null) {
            if (node.getItem().equals(value)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        var stringBuilder = new StringBuilder("[");
        var node = firstNode;
        while (node != null) {
            stringBuilder.append(node.getItem());
            if (node.getNext() != null) {
                stringBuilder.append(" -> ");
            }
            node = node.getNext();
        }
        System.out.println(stringBuilder.append("]"));
    }

    // 3 задание. Реализовать метод insert в классе списка.
    @Override
    public void insert(int index, E value) {
        if (index > size) {
            throw new IllegalArgumentException("index should be less than or equal size");
        }

        var curIndex = 0;
        Node<E> prevNode = null;
        var node = firstNode;
        while (curIndex <= size) {
            if (curIndex == index) {
                var newNode = new Node<>(value, node);
                if (prevNode == null) {
                    firstNode = newNode;
                } else {
                    prevNode.setNext(newNode);
                }
                size++;
                return;
            }
            curIndex++;
            prevNode = node;
            node = node.getNext();
        }
    }

    // 2 задание. Реализовать итератор.
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> currentNode;

        public LinkedListIterator() {
            this.currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            if (currentNode == null) {
                return null;
            }

            var node = currentNode;
            currentNode = currentNode.getNext();
            return node.getItem();
        }
    }
}
