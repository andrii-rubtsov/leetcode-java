package _2592_maximize_greatness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test_0() {
        int ans = new Solution().maximizeGreatness(new int[]{1,3,5,2,1,3,1});
        assertEquals(4, ans);
    }

    @Test
    void test_1() {
        int ans = new Solution().maximizeGreatness(new int[]{1,2,3,4});
        assertEquals(3, ans);
    }

}