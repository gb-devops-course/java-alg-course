import com.courses.alg.list.LinkedList;
import com.courses.alg.list.impl.SimpleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleLinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SimpleLinkedList<>();
    }

    @Test
    void getFirstTest() {
        prepareList();

        assertEquals(30, list.getFirst());
    }

    @Test
    void insertFirstTest() {
        prepareList();

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
    }

    @Test
    void insertTest() {
        list.insert(0, 10);
        assertEquals(1, list.size());
        assertEquals(10, list.getFirst());

        list.insert(1, 20);
        assertEquals(2, list.size());
        assertEquals(10, list.getFirst());

        list.insert(2, 30);
        assertEquals(3, list.size());
        assertEquals(10, list.getFirst());

        list.insert(3, 40);
        assertEquals(4, list.size());
        assertEquals(10, list.getFirst());

        list.insert(0, 50);
        assertEquals(5, list.size());
        assertEquals(50, list.getFirst());

        list.insert(1, 60);
        assertEquals(6, list.size());
        assertEquals(50, list.getFirst());

        list.insert(6, 80);
        assertEquals(7, list.size());
        assertEquals(50, list.getFirst());

        list.insert(7, 90);
        assertEquals(8, list.size());
        assertEquals(50, list.getFirst());
    }

    @Test
    void insertWithWrongIndexFailedTest() {
        assertThrows(IllegalArgumentException.class, () -> list.insert(2, 10));
    }

    @Test
    void removeFirstTest() {
        prepareList();

        var result = list.removeFirst();
        assertEquals(30, result);
        assertEquals(2, list.size());
    }

    @Test
    void removeTest() {
        prepareList();

        list.remove(20);
        assertEquals(2, list.size());
        assertEquals(30, list.getFirst());
    }

    @Test
    void containsTest() {
        prepareList();

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertTrue(list.contains(30));
        assertFalse(list.contains(40));
    }

    private void prepareList() {
        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
    }
}
