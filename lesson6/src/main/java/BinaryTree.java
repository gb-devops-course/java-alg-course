public class BinaryTree<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;

    @Override
    public boolean contains(E value) {
        return find(root, value) != null;
    }

    @Override
    public void add(E value) {
        root = doAdd(root, value);
    }

    @Override
    public void remove(E value) {
        root = doRemove(root, value);
    }

    @Override
    public int height() {
        return height(root);
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private Node<E> find(Node<E> node, E value) {
        if (node == null || node.getValue().equals(value)) {
            return node;
        }

        if (node.getValue().compareTo(value) < 0) {
            return find(node.getRight(), value);
        }
        if (node.getValue().compareTo(value) > 0) {
            return find(node.getLeft(), value);
        }

        return null;
    }

    private Node<E> doAdd(Node<E> node, E value) {
        if (node == null) {
            node = new Node<>(value);
            return node;
        }

        if (node.getValue().compareTo(value) < 0) {
            node.setRight(doAdd(node.getRight(), value));
        } else if (node.getValue().compareTo(value) > 0) {
            node.setLeft(doAdd(node.getLeft(), value));
        }

        return node;
    }

    private Node<E> doRemove(Node<E> node, E value) {
        if (node == null) {
            return null;
        }

        if (node.getValue().compareTo(value) < 0) {
            node.setRight(doRemove(node.getRight(), value));
        } else if (node.getValue().compareTo(value) > 0) {
            node.setLeft(doRemove(node.getLeft(), value));
        } else {
            if (node.isLeaf()) {
                node = null;
            } else if (node.hasOnlyOneChild()) {
                node = node.getLeft() == null ? node.getRight() : node.getLeft();
            } else {
                Node<E> max = findMax(node.getLeft());
                node.setValue(max.getValue());
                node.setLeft(doRemove(node.getLeft(), max.getValue()));
            }
        }

        return node;
    }

    private Node<E> findMax(Node<E> node) {
        if (node.getRight() == null) {
            return node;
        }
        return findMax(node.getRight());
    }

    public int height(Node<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean isBalanced(Node<E> node) {
        return (node == null)
                || isBalanced(node.getLeft())
                && isBalanced(node.getRight())
                && Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1;
    }
}
