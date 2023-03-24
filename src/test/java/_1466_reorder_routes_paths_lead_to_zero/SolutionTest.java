package _1466_reorder_routes_paths_lead_to_zero;

import org.junit.jupiter.api.Test;

import static common.utils.TestUtils.array2d;
import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    public void test_1() {
        int actual = new Solution().minReorder(
                6,
                array2d("[[0,1],[1,3],[2,3],[4,0],[4,5]]"));
        assertEquals(3, actual);
    }

    @Test
    public void test_2() {
        int actual = new Solution().minReorder(
                5,
                array2d("[[1,0],[1,2],[3,2],[3,4]]"));
        assertEquals(2, actual);
    }

    @Test
    public void test_3() {
        int actual = new Solution().minReorder(
                3,
                array2d("[[1,0],[2,0]]"));
        assertEquals(0, actual);
    }

}