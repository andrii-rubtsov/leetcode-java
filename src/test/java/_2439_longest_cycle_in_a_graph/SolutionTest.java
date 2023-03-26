package _2439_longest_cycle_in_a_graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    public void test_0() {
        int actual = new Solution().longestCycle(
                new int[]{3,3,4,2,3}
        );
        assertEquals(3, actual);
    }

    @Test
    public void test_1() {
        int actual = new Solution().longestCycle(
                new int[]{2,-1,3,1}
        );
        assertEquals(-1, actual);
    }

    @Test
    public void test_2() {
        int actual = new Solution().longestCycle(
                new int[]{-1,4,-1,2,0,4}
        );
        assertEquals(-1, actual);
    }

    @Test
    public void test_3() {
        int actual = new Solution().longestCycle(
                new int[]{3,4,0,2,-1,2}
        );
        assertEquals(3, actual);
    }

    @Test
    public void test_4() {
        int actual = new Solution().longestCycle(
                new int[]{1,2,0,4,5,6,3,8,9,7}
        );
        assertEquals(4, actual);
    }

}