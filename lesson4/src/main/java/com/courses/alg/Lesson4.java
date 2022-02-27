package com.courses.alg;

import com.courses.alg.deque.impl.SimpleDeque;
import com.courses.alg.list.impl.SimpleDelinkedList;
import com.courses.alg.list.impl.SimpleLinkedList;

public class Lesson4 {

    public static void main(String[] args) {
        checkLinkedList();
        checkDelinkedList();
        checkDeque();
        checkIterable();
    }

    private static void checkLinkedList() {
        var linkedList = new SimpleLinkedList<Integer>();
        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(30);
        linkedList.insertFirst(40);
        linkedList.insertFirst(50);
        linkedList.display();

        linkedList.insert(0, 100);
        linkedList.display();

        linkedList.insert(3, 200);
        linkedList.display();

        linkedList.insert(5, 300);
        linkedList.display();
    }

    private static void checkDelinkedList() {
        var linkedList = new SimpleDelinkedList<Integer>();
        linkedList.insertFirst(10);
        linkedList.display();
        linkedList.insertFirst(20);
        linkedList.display();
        linkedList.insertFirst(30);
        linkedList.display();
        linkedList.insertLast(40);
        linkedList.display();
        linkedList.insertLast(50);
        linkedList.display();

        linkedList.removeFirst();
        linkedList.display();
        linkedList.removeLast();
        linkedList.display();

        System.out.println(linkedList.contains(20));
        System.out.println(linkedList.contains(40));
        System.out.println(linkedList.contains(60));

        System.out.println(linkedList.remove(10));
        linkedList.display();

        System.out.println(linkedList.removeLast());
        linkedList.display();

        System.out.println(linkedList.removeLast());
        linkedList.display();

        System.out.println(linkedList.removeLast());
        linkedList.display();
    }

    private static void checkDeque() {
        var deque = new SimpleDeque<Integer>();
        deque.insertFirst(10);
        deque.insertFirst(20);
        deque.insertFirst(30);
        deque.insertLast(40);
        deque.insertLast(50);
        deque.display();

        deque.removeFirst();
        deque.display();
        deque.removeLast();
        deque.display();

        System.out.println(deque.removeLast());
        deque.display();

        System.out.println(deque.removeLast());
        deque.display();

        System.out.println(deque.removeLast());
        deque.display();

        deque = new SimpleDeque<Integer>();
        deque.insertFirst(10);
        deque.insertFirst(20);
        deque.insertFirst(30);
        deque.insertFirst(40);
        deque.insertFirst(50);
        deque.display();

        deque.remove(20);
        deque.remove(30);
        deque.remove(300);
        deque.display();

        deque.remove(10);
        deque.display();
        deque.remove(40);
        deque.display();
        deque.remove(50);
        deque.display();
    }

    private static void checkIterable() {
        checkEmptyList();
        checkListWithElements();
        checkIterator();
    }

    private static void checkEmptyList() {
        var list = new SimpleLinkedList<Integer>();
        for (var item : list) {
            System.out.println(item);
        }
    }

    private static void checkListWithElements() {
        var list = new SimpleLinkedList<Integer>();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertFirst(50);
        list.insertFirst(60);

        for (var item : list) {
            System.out.println(item * 10);
        }
    }

    private static void checkIterator() {
        var list = new SimpleLinkedList<Integer>();
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertFirst(50);
        list.insertFirst(60);

        var iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() * 100);
        }

        System.out.println(iterator.next()); // null
    }
}
