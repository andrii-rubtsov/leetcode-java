package _0882_peak_index_in_a_mountain_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test_0() {
        int actual = new Solution().peakIndexInMountainArray(
                new int[]{0, 1, 0}
        );
        assertEquals(1, actual);
    }

    @Test
    public void test_1() {
        int actual = new Solution().peakIndexInMountainArray(
                new int[]{0, 2, 1, 0}
        );
        assertEquals(1, actual);
    }

    @Test
    public void test_2() {
        int actual = new Solution().peakIndexInMountainArray(
                new int[]{0, 10, 5, 2}
        );
        assertEquals(1, actual);
    }

    @Test
    public void test_3() {
        int actual = new Solution().peakIndexInMountainArray(
                new int[]{3, 4, 5, 1}
        );
        assertEquals(2, actual);
    }

    @Test
    public void test_4() {
        int actual = new Solution().peakIndexInMountainArray(
                new int[]{55, 59, 63, 99, 97, 94, 84, 81, 79, 66, 40, 38, 33, 23, 22, 21, 17, 9, 7}
        );
        assertEquals(3, actual);
    }

}