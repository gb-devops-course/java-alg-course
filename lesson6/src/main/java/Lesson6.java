import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson6 {

    private static final int TREES_NUM = 20;

    private static final int LOWEST_NUM = -25;
    private static final int HIGHEST_NUM = 25;
    private static final int PRICE_BOUND = HIGHEST_NUM - LOWEST_NUM + 1;

    private static final Random random = new Random();

    private static final List<BinaryTree<Integer>> trees = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < TREES_NUM; i++) {
            trees.add(createTree());
        }

        long unbalancedTreesCount = trees.stream().filter(t -> !t.isBalanced()).count();
        double unbalancedTreesPercentage = (double) unbalancedTreesCount / TREES_NUM * 100.0;
        System.out.println("unbalancedTreesCount " + unbalancedTreesCount);
        System.out.println("unbalancedTreesPercentage " + unbalancedTreesPercentage);
    }

    private static BinaryTree<Integer> createTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        while (tree.height() < 4) {
            tree.add(nextRandom());
        }

        return tree;
    }

    private static int nextRandom() {
        return random.nextInt(PRICE_BOUND) + LOWEST_NUM;
    }
}
