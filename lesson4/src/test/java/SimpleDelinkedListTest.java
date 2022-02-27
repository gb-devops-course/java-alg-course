import com.courses.alg.list.DelinkedList;
import com.courses.alg.list.impl.SimpleDelinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleDelinkedListTest {

    private DelinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SimpleDelinkedList<>();
        prepareList();
    }

    @Test
    void getLastTest() {
        assertEquals(10, list.getLast());
    }

    @Test
    void insertLastTest() {
        list.insertLast(60);

        assertEquals(4, list.size());
        assertEquals(30, list.getFirst());
        assertEquals(60, list.getLast());
    }

    @Test
    void getFirstTest() {
        assertEquals(30, list.getFirst());
    }

    @Test
    void insertFirstTest() {
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
    }

    @Test
    void removeFirstTest() {
        var result = list.removeFirst();
        assertEquals(30, result);
        assertEquals(2, list.size());
    }

    @Test
    void removeTest() {
        list.remove(20);
        assertEquals(2, list.size());
        assertEquals(30, list.getFirst());
    }

    @Test
    void containsTest() {
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
