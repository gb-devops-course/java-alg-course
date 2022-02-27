import com.courses.alg.deque.Deque;
import com.courses.alg.deque.impl.SimpleDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleDequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    void setUp() {
        deque = new SimpleDeque<>();
    }

    @Test
    void insertFirst() {
        deque.insertFirst(30);
        deque.insertFirst(20);
        deque.insertFirst(10);

        assertEquals(3, deque.size());
    }

    @Test
    void insertLast() {
        deque.insertLast(10);
        deque.insertLast(20);
        deque.insertLast(30);

        assertEquals(3, deque.size());
    }

    @Test
    void remove() {
        deque.insertLast(10);
        deque.insertLast(20);
        deque.insertLast(30);

        deque.remove(20);

        assertEquals(2, deque.size());
        assertEquals(10, deque.peekFront());
        assertEquals(30, deque.peekLast());
    }

    @Test
    void removeFirst() {
        deque.insertLast(10);
        deque.insertLast(20);
        deque.insertLast(30);

        deque.removeFirst();

        assertEquals(2, deque.size());
        assertEquals(20, deque.peekFront());
    }

    @Test
    void removeLast() {
        deque.insertLast(10);
        deque.insertLast(20);
        deque.insertLast(30);

        deque.removeLast();

        assertEquals(2, deque.size());
        assertEquals(20, deque.peekLast());
    }

    @Test
    void peekFront() {
        deque.insertLast(10);
        deque.insertLast(20);

        assertEquals(10, deque.peekFront());
    }

    @Test
    void peekLast() {
        deque.insertLast(10);
        deque.insertLast(20);

        assertEquals(20, deque.peekLast());
    }

    @Test
    void size() {
        deque.insertLast(10);
        deque.insertLast(20);

        assertEquals(2, deque.size());
    }

    @Test
    void isEmpty() {
        assertTrue(deque.isEmpty());

        deque.insertLast(10);

        assertFalse(deque.isEmpty());
    }
}