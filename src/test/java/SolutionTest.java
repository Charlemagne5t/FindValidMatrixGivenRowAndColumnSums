import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void test1() {
        int[] rowSum = {3, 8};
        int[] colSum = {4,7};
        int[][] res = new Solution().restoreMatrix(rowSum, colSum);

        for(int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
    @Test
    public void test2() {
        int[] rowSum = {5, 7, 10};
        int[] colSum = {8,6,8};
        int[][] res = new Solution().restoreMatrix(rowSum, colSum);

        for(int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}
