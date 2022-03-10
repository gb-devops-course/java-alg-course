import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree<>();
    }

    @Test
    public void addTest() {
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(6);
        binaryTree.add(8);

        assertTrue(binaryTree.contains(5));
        assertTrue(binaryTree.contains(3));
        assertTrue(binaryTree.contains(2));
        assertTrue(binaryTree.contains(4));
        assertTrue(binaryTree.contains(7));
        assertTrue(binaryTree.contains(6));
        assertTrue(binaryTree.contains(8));
        assertFalse(binaryTree.contains(99));
    }

    @Test
    void balancedHeightTest() {
        assertEquals(0, binaryTree.height());

        binaryTree.add(5);
        assertEquals(1, binaryTree.height());

        binaryTree.add(3);
        assertEquals(2, binaryTree.height());

        binaryTree.add(2);
        assertEquals(3, binaryTree.height());

        binaryTree.add(4);
        assertEquals(3, binaryTree.height());

        binaryTree.add(7);
        assertEquals(3, binaryTree.height());

        binaryTree.add(6);
        assertEquals(3, binaryTree.height());

        binaryTree.add(8);
        assertEquals(3, binaryTree.height());
    }

    @Test
    void unbalancedHeightTest() {
        assertEquals(0, binaryTree.height());

        binaryTree.add(2);
        assertEquals(1, binaryTree.height());

        binaryTree.add(3);
        assertEquals(2, binaryTree.height());

        binaryTree.add(5);
        assertEquals(3, binaryTree.height());

        binaryTree.add(6);
        assertEquals(4, binaryTree.height());

        binaryTree.add(4);
        assertEquals(4, binaryTree.height());

        binaryTree.add(7);
        assertEquals(5, binaryTree.height());

        binaryTree.add(8);
        assertEquals(6, binaryTree.height());
    }

    @Test
    void removeWithNoChildTest() {
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(6);
        binaryTree.add(8);

        binaryTree.remove(2);

        assertFalse(binaryTree.contains(2));
        assertTrue(binaryTree.contains(5));
        assertTrue(binaryTree.contains(3));
        assertTrue(binaryTree.contains(4));
    }

    @Test
    void removeWithOneChildTest() {
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(8);

        binaryTree.remove(7);

        assertFalse(binaryTree.contains(7));
        assertTrue(binaryTree.contains(5));
        assertTrue(binaryTree.contains(8));
    }

    @Test
    void removeWithTwoChildTest() {
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(6);
        binaryTree.add(8);

        binaryTree.remove(3);

        assertFalse(binaryTree.contains(3));
        assertTrue(binaryTree.contains(5));
        assertTrue(binaryTree.contains(2));
        assertTrue(binaryTree.contains(4));
    }
}
