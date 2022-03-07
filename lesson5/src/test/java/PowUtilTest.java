import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pow.PowUtil;

public class PowUtilTest {
    
    private static final double DIFF_CONST = 0.00000001;

    @Test
    void test() {
        Assertions.assertTrue(Math.pow(3, 0) - PowUtil.pow(3, 0) < DIFF_CONST);

        Assertions.assertTrue(Math.pow(2, 1) - PowUtil.pow(2, 1) < DIFF_CONST);
        Assertions.assertTrue(Math.pow(2, -1) - PowUtil.pow(2, -1) < DIFF_CONST);

        Assertions.assertTrue(Math.pow(5, 3) - PowUtil.pow(5, 3) < DIFF_CONST);
        Assertions.assertTrue(Math.pow(5, -3) - PowUtil.pow(5, -3) < DIFF_CONST);

        Assertions.assertTrue(Math.pow(1, 3) - PowUtil.pow(1, 3) < DIFF_CONST);
        Assertions.assertTrue(Math.pow(1, -3) - PowUtil.pow(1, -3) < DIFF_CONST);

        Assertions.assertTrue(Math.pow(324, 5) - PowUtil.pow(324, 5) < DIFF_CONST);
        Assertions.assertTrue(Math.pow(324, -5) - PowUtil.pow(324, -5) < DIFF_CONST);
    }
}
