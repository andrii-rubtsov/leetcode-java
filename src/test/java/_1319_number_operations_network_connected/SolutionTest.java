package _1319_number_operations_network_connected;

import common.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    public void test_1() {
        int actual = new Solution().makeConnected(
                4,
                new int[][]{{0, 1}, {0, 2}, {1, 2}});
        assertEquals(1, actual);
    }

    @Test
    public void test_2() {
        int actual = new Solution().makeConnected(
                6,
                new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}});
        assertEquals(2, actual);
    }

    @Test
    public void test_3() {
        int actual = new Solution().makeConnected(
                10000,
                TestUtils.array2dFromClasspath(this.getClass().getPackageName(), "test3_input.txt"));
        assertEquals(1064, actual);
    }

}
