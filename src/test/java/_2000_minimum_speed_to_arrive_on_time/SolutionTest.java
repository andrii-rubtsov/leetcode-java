package _2000_minimum_speed_to_arrive_on_time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test_0() {
        int actual = new Solution().minSpeedOnTime(
                new int[]{1, 3, 2}, 6
        );
        assertEquals(1, actual);
    }

    @Test
    public void test_1() {
        int actual = new Solution().minSpeedOnTime(
                new int[]{1, 3, 2}, 2.7
        );
        assertEquals(3, actual);
    }

    @Test
    public void test_2() {
        int actual = new Solution().minSpeedOnTime(
                new int[]{1, 3, 2}, 1.9
        );
        assertEquals(-1, actual);
    }

    @Test
    public void test_3() {
        int actual = new Solution().minSpeedOnTime(
                new int[]{1, 1, 100000}, 2.01
        );
        assertEquals(10000000, actual);
    }

    @Test
    public void test_4() {
        int actual = new Solution().minSpeedOnTime(
                new int[]{5, 3, 4, 6, 2, 2, 7}, 10.92
        );
        assertEquals(4, actual);
    }

}