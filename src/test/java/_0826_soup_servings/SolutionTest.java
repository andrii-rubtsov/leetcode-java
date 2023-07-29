package _0826_soup_servings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test_0() {
        double actual = new Solution().soupServings(50);
        assertEquals(0.625, actual, 1e-5);
    }

    @Test
    public void test_1() {
        double actual = new Solution().soupServings(100);
        assertEquals(0.71875, actual, 1e-5);
    }

    @Test
    public void test_3() {
        double actual = new Solution().soupServings(0);
        assertEquals(0.5, actual, 1e-5);
    }

    @Test
    public void test_4() {
        double actual = new Solution().soupServings(1);
        assertEquals(0.625, actual, 1e-5);
    }

    @Test
    public void test_5() {
        double actual = new Solution().soupServings(660_295_675);
        assertEquals(1, actual, 1e-5);
    }


}