package _0688_knight_probability_in_chessboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    public void test_0() {
        double actual = new Solution().knightProbability(3, 2, 0, 0);
        assertEquals(0.0625, actual);
    }

    @Test
    public void test_1() {
        double actual = new Solution().knightProbability(1, 0, 0, 0);
        assertEquals(1.0, actual);
    }

    @Test
    public void test_2() {
        double actual = new Solution().knightProbability(8, 30, 6, 4);
        assertEquals(0.00019, actual, 0.000001);
    }

}