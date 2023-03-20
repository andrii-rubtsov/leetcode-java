package _2593_find_score_array_marked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void test_0() {
        long ans = new Solution().findScore(new int[]{2,1,3,4,5,2});
        assertEquals(7, ans);
    }

    @Test
    void test_1() {
        long ans = new Solution().findScore(new int[]{2,3,5,1,3,2});
        assertEquals(5, ans);
    }
}