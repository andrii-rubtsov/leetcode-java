package _0064_minimum_path_sum;

import org.junit.jupiter.api.Test;

import static common.TestUtils.array2d;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test_0() {
        int actual = new Solution().minPathSum(
                array2d("[[1,3,1],[1,5,1],[4,2,1]]"));
        assertEquals(7, actual);
    }

    @Test
    public void test_1() {
        int actual = new Solution().minPathSum(
                array2d("[[1,3,1],[1,5,1],[4,2,1]]"));
        assertEquals(7, actual);
    }

    @Test
    public void test_2() {
        int actual = new Solution().minPathSum(
                array2d("[[1,2,3],[4,5,6]]"));
        assertEquals(12, actual);
    }

}