package _2492_minimum_score_path_two_cities;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test_1() {
        long actual = new Solution().minScore(
                4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}
        );
        assertEquals(5, actual);
    }

    @Test
    public void test_2() {
        long actual = new Solution().minScore(
                4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}
        );
        assertEquals(2, actual);
    }

    @Test
    public void test_3() {
        long actual = new Solution().minScore(
                6, new int[][]{{4, 5, 7468}, {6, 2, 7173}, {6, 3, 8365}, {2, 3, 7674}, {5, 6, 7852}, {1, 2, 8547}, {2, 4, 1885}, {2, 5, 5192}, {1, 3, 4065}, {1, 4, 7357}}
        );
        assertEquals(1885, actual);
    }


}