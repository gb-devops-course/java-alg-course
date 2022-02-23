import java.util.ArrayList;
import java.util.Arrays;

public class FindMissingNumberTask {

    private static final int COUNT = 10000;

    private static int iterations = 0;

    public static void main(String[] args) {
        check(new Integer[] {}); // result=1, iterations=0
        check(genArray(COUNT, 0)); // result=1, iterations=13
        check(genArray(COUNT, 1)); // result=2, iterations=12
        check(genArray(COUNT, COUNT - 1)); // result=10000, iterations=14
        check(genArray(COUNT, COUNT / 2)); // result=5001, iterations=13
        check(genArray(COUNT, COUNT / 3)); // result=3334, iterations=11
        check(genArray(COUNT, COUNT / 4)); // result=2501, iterations=13
        check(genArray(COUNT, COUNT / 10)); // result=1001, iterations=13
        check(genArray(COUNT, COUNT - 10)); // result=9991, iterations=13
    }

    private static void check(Integer[] array) {
//        System.out.println(Arrays.toString(array));
        System.out.printf("result=%d, iterations=%d%n", findMissedNumber(array), iterations);
    }

    private static int findMissedNumber(Integer[] array) {
        int start = 0;
        int end = array.length - 1;
        int base = 0;

        iterations = 0;
        while (end >= start) {
            iterations++;
            base = (start + end) / 2;
            if (base > 0 && array[base] - array[base-1] > 1) {
                return array[base] - 1;
            }
            if (array[base] == base + 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }

        if (base == 0) {
            return base + 1;
        }
        return array[base] + 1;
    }

    private static Integer[] genArray(int count, int indexToDelete) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arrayList.add(i + 1);
        }
        arrayList.remove(indexToDelete);
        return arrayList.toArray(new Integer[] {});
    }
}
