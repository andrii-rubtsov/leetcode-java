package _983_minimum_cost_for_tickets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test_0() {
        int actual = new Solution().mincostTickets(
                new int[]{1, 4, 6, 7, 8, 20},
                new int[]{2, 7, 15}
        );
        assertEquals(11, actual);
    }

    @Test
    public void test_1() {
        int actual = new Solution().mincostTickets(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31},
                new int[]{2, 7, 15}
        );
        assertEquals(17, actual);
    }

    @Test
    public void test_2() {
        int actual = new Solution().mincostTickets(
                new int[]{2, 3, 5, 6, 7, 8, 9, 10, 11, 17, 18, 19, 23, 26, 27, 29, 31, 32, 33, 34, 35, 36, 38, 39, 40, 41, 42, 43, 44, 45, 47, 51, 54, 55, 57, 58, 64, 65, 67, 68, 72, 73, 74, 75, 77, 78, 81, 86, 87, 88, 89, 91, 93, 94, 95, 96, 98, 99},
                new int[]{5, 24, 85}
        );
        assertEquals(246, actual);
    }

    @Test
    public void test_3() {
        int actual = new Solution().mincostTickets(
                new int[]{364},
                new int[]{3, 3, 1}
        );
        assertEquals(1, actual);
    }

}