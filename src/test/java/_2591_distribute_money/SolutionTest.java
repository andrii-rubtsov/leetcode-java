package _2591_distribute_money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void test_0() {
        int ans = new Solution().distMoney(20, 3);
        assertEquals(1, ans);
    }

    @Test
    void test_1() {
        int ans = new Solution().distMoney(16, 2);
        assertEquals(2, ans);
    }

    @Test
    void test_2() {
        int ans = new Solution().distMoney(12, 2);
        assertEquals(0, ans);
    }

    @Test
    void test_3() {
        int ans = new Solution().distMoney(4, 2);
        assertEquals(0, ans);
    }

    @Test
    void test_4() {
        int ans = new Solution().distMoney(8, 2);
        assertEquals(0, ans);
    }

    @Test
    void test_5() {
        int ans = new Solution().distMoney(9, 3);
        assertEquals(0, ans);
    }

    @Test
    void test_6() {
        int ans = new Solution().distMoney(1, 2);
        assertEquals(-1, ans);
    }

    @Test
    void test_7() {
        int ans = new Solution().distMoney(13, 3);
        assertEquals(1, ans);
    }

    @Test
    void test_8() {
        int ans = new Solution().distMoney(17, 2);
        assertEquals(1, ans);
    }

    @Test
    void test_9() {
        int ans = new Solution().distMoney(23, 2);
        assertEquals(1, ans);
    }
}