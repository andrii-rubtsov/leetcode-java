package _2403_count_unreachable_pairs_of_nodes_in_an_undirected_graph;

import org.junit.jupiter.api.Test;

import static common.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    public void test_0() {
        long actual = new Solution().countPairs(
                3,
                array2d("[[0,1],[0,2],[1,2]]"));
        assertEquals(0, actual);
    }

    @Test
    public void test_1() {
        long actual = new Solution().countPairs(
                7,
                array2d("[[0,2],[0,5],[2,4],[1,6],[5,4]]"));
        assertEquals(14, actual);
    }

    @Test
    public void test_2() {
        long actual = new Solution().countPairs(
                5,
                array2d("[[1,0],[3,1],[0,4],[2,1]]"));
        assertEquals(0, actual);
    }

    @Test
    public void test_3() {
        long actual = new Solution().countPairs(
                100_000,
                array2d("[]"));
        assertEquals(4999950000L, actual);
    }

}