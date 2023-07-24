package _0050_powx_n;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    double ACCURACY = 0.000001;

    @Test
    public void test_0() {
        assertEquals(new Solution().myPow(2.0, 10), 1024.0, ACCURACY);
    }

    @Test
    public void test_1() {
        assertEquals(new Solution().myPow(2.1, 3), 9.261, ACCURACY);
    }

    @Test
    public void test_2() {
        assertEquals(new Solution().myPow(2.0, -2), 0.25, ACCURACY);
    }

}