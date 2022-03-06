package com.courses.alg.deque.impl;

import com.courses.alg.deque.Deque;

// 1 задание. Реализовать Deque (с возможностью обратного прохода).
public class SimpleDeque<E> implements Deque<E> {

    private Node<E> headNode;
    private Node<E> tailNode;

    private int size = 0;

    @Override
    public void insertFirst(E value) {
        size++;
        var newNode = new Node<>(value, null, headNode);
        if (headNode != null) {
            headNode.setPrev(newNode);
        }
        headNode = newNode;
        if (size == 1) {
            tailNode = headNode;
        }
    }

    @Override
    public void insertLast(E value) {
        size++;
        var newNode = new Node<>(value, tailNode, null);
        if (tailNode != null) {
            tailNode.setNext(newNode);
        }
        tailNode = newNode;
        if (size == 1) {
            headNode = tailNode;
        }
    }

    @Override
    public void remove(E value) {
        if (isEmpty()) {
            return;
        }

        if (headNode.getItem().equals(value)) {
            headNode = headNode.getNext();
            size--;
            return;
        }

        var node = headNode.getNext();
        var prevNode = headNode;
        while (node != null) {
            if (node.getItem().equals(value)) {
                prevNode.setNext(node.getNext());
                size--;
                return;
            }
            prevNode = node;
            node = node.getNext();
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        var item = headNode.getItem();

        if (headNode == tailNode) {
            headNode = null;
            tailNode = null;
        } else {
            var curNode = headNode;
            headNode = headNode.getNext();
            headNode.setPrev(null);
            curNode.setNext(null);
        }

        size--;
        return item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        var item = tailNode.getItem();

        if (headNode == tailNode) {
            headNode = null;
            tailNode = null;
        } else {
            var prevNode = tailNode.getPrev();
            tailNode.setPrev(null);

            tailNode = prevNode;
            tailNode.setNext(null);
        }

        size--;
        return item;
    }

    @Override
    public E peekFront() {
        if (isEmpty()) {
            return null;
        }
        return headNode.getItem();
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return tailNode.getItem();
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
        var node = headNode;
        while (node != null) {
            stringBuilder.append(node.getItem());
            if (node.getNext() != null) {
                stringBuilder.append(" -> ");
            }
            node = node.getNext();
        }
        System.out.println(stringBuilder.append("]"));
    }
}
