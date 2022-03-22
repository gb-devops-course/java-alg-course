import lombok.Data;

@Data
public class Node<T extends Comparable<? super T>> {

    private T value;

    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasOnlyOneChild() {
        return left != null ^ right != null;
    }
}
