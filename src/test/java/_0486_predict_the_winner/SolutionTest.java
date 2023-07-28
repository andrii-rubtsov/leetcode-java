package _0486_predict_the_winner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test_0() {
        boolean actual = new Solution().PredictTheWinner(
                new int[]{1, 5, 2});
        assertEquals(false, actual);
    }

    @Test
    public void test_1() {
        boolean actual = new Solution().PredictTheWinner(
                new int[]{1, 5, 233, 7});
        assertEquals(true, actual);
    }

}