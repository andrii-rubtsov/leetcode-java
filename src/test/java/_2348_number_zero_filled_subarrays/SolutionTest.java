package _2348_number_zero_filled_subarrays;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    public static int[] arrayOfInts(int... num) {
        return num;
    }

    public static long[] arrayOfLongs(long... num) {
        return num;
    }

    @Test
    public void test_1() {
        long actual = new Solution().zeroFilledSubarray(arrayOfInts(1,3,0,0,2,0,0,4));
        assertEquals(6, actual);
    }

    @Test
    public void test_2() {
        long actual = new Solution().zeroFilledSubarray(arrayOfInts(0,0,0,2,0,0));
        assertEquals(9, actual);
    }


}