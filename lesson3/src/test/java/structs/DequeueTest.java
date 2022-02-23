package structs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DequeueTest {

    private static final int CAPACITY = 5;

    private Dequeue<Integer> dequeue;

    @BeforeEach
    void setUp() {
        dequeue = new Dequeue<>(CAPACITY);
    }

    @Test
    void testInsert() {
        var result = dequeue.insert(20);

        assertTrue(result);
        assertEquals(1, dequeue.size());
    }

    @Test
    void testRemove() {
        dequeue.insert(10);
        dequeue.insert(20);
        dequeue.insert(30);

        var result = dequeue.remove();

        assertEquals(10, result);
        assertEquals(2, dequeue.size());
    }

    @Test
    void testPeekFront() {
        dequeue.insert(10);
        dequeue.insert(20);
        dequeue.insert(30);

        var result = dequeue.peekFront();

        assertEquals(10, result);
        assertEquals(3, dequeue.size());
    }

    @Test
    void testSize() {
        dequeue.insert(10);
        dequeue.insert(20);
        dequeue.insert(30);
        dequeue.insert(40);

        assertEquals(4, dequeue.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(dequeue.isEmpty());
        assertEquals(0, dequeue.size());

        for (int i = 0; i < CAPACITY; i++) {
            dequeue.insert(i);
        }
        for (int i = 0; i < CAPACITY; i++) {
            dequeue.remove();
        }

        assertTrue(dequeue.isEmpty());
        assertEquals(0, dequeue.size());
    }

    @Test
    void testIsFull() {
        assertFalse(dequeue.isFull());

        for (int i = 0; i < CAPACITY; i++) {
            dequeue.insert(i);
        }

        assertEquals(CAPACITY, dequeue.size());
        assertTrue(dequeue.isFull());
    }

    @Test
    void testInsertFalseWhenCapacityIsReached() {
        for (int i = 0; i < CAPACITY; i++) {
            dequeue.insert(i);
        }

        assertEquals(CAPACITY, dequeue.size());
        assertFalse(dequeue.insert(10));
    }

    @Test
    void testHeadTailValues() {
        assertTrue(dequeue.isEmpty());
        assertEquals(0, dequeue.size());

        for (int i = 0; i < CAPACITY; i++) {
            dequeue.insert(i);
        }
        for (int i = 0; i < CAPACITY; i++) {
            dequeue.remove();
        }

        assertTrue(dequeue.isEmpty());
        assertEquals(0, dequeue.size());

        assertEquals(0, dequeue.getHead());
        assertEquals(4, dequeue.getTail());

        dequeue.insert(1);
        assertEquals(1, dequeue.size());
        assertEquals(0, dequeue.getHead());
        assertEquals(0, dequeue.getTail());

        dequeue.insert(2);
        assertEquals(2, dequeue.size());
        assertEquals(0, dequeue.getHead());
        assertEquals(1, dequeue.getTail());

        dequeue.insert(3);
        assertEquals(3, dequeue.size());
        assertEquals(0, dequeue.getHead());
        assertEquals(2, dequeue.getTail());

        dequeue.insert(4);
        assertEquals(4, dequeue.size());
        assertEquals(0, dequeue.getHead());
        assertEquals(3, dequeue.getTail());

        dequeue.insert(5);
        assertEquals(5, dequeue.size());
        assertEquals(0, dequeue.getHead());
        assertEquals(4, dequeue.getTail());

        dequeue.remove();
        assertEquals(4, dequeue.size());
        assertEquals(1, dequeue.getHead());
        assertEquals(4, dequeue.getTail());

        dequeue.insert(6);
        assertEquals(5, dequeue.size());
        assertEquals(1, dequeue.getHead());
        assertEquals(0, dequeue.getTail());
    }

    @Test
    void testFullCyclingDequeue() {
        dequeue.insert(10); // head=0, tail=0
        assertEquals(0, dequeue.getHead());
        assertEquals(0, dequeue.getTail());

        dequeue.insert(20); // head=0, tail=1
        assertEquals(0, dequeue.getHead());
        assertEquals(1, dequeue.getTail());

        dequeue.insert(30); // head=0, tail=2
        assertEquals(0, dequeue.getHead());
        assertEquals(2, dequeue.getTail());

        dequeue.insert(40); // head=0, tail=3
        assertEquals(0, dequeue.getHead());
        assertEquals(3, dequeue.getTail());

        assertEquals(4, dequeue.size());

        var removed1 = dequeue.remove(); // head=1, tail=3
        assertEquals(1, dequeue.getHead());
        assertEquals(3, dequeue.getTail());

        var removed2 = dequeue.remove(); // head=2, tail=3
        assertEquals(2, dequeue.getHead());
        assertEquals(3, dequeue.getTail());

        assertEquals(10, removed1);
        assertEquals(20, removed2);
        assertEquals(2, dequeue.size());

        dequeue.insert(50); // head=2, tail=4
        assertEquals(2, dequeue.getHead());
        assertEquals(4, dequeue.getTail());

        dequeue.insert(60); // head=2, tail=0
        assertEquals(2, dequeue.getHead());
        assertEquals(0, dequeue.getTail());

        assertEquals(4, dequeue.size());

        dequeue.insert(70); // head=2, tail=1
        assertEquals(2, dequeue.getHead());
        assertEquals(1, dequeue.getTail());

        assertEquals(5, dequeue.size());
        assertTrue(dequeue.isFull());
        assertFalse(dequeue.insert(100500));

        var removed3 = dequeue.remove(); // head=3, tail=1
        assertEquals(3, dequeue.getHead());
        assertEquals(1, dequeue.getTail());

        var removed4 = dequeue.remove(); // head=4, tail=1
        assertEquals(4, dequeue.getHead());
        assertEquals(1, dequeue.getTail());

        var removed5 = dequeue.remove(); // head=0, tail=1
        assertEquals(0, dequeue.getHead());
        assertEquals(1, dequeue.getTail());

        assertEquals(30, removed3);
        assertEquals(40, removed4);
        assertEquals(50, removed5);

        assertEquals(2, dequeue.size());
    }
}