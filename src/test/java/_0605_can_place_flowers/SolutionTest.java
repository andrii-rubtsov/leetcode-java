package _0605_can_place_flowers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test_1() {
        boolean actual = new Solution().canPlaceFlowers(new int[]{1,0,0,0,1}, 1);
        assertEquals(true, actual);
    }

    @Test
    public void test_2() {
        boolean actual = new Solution().canPlaceFlowers(new int[]{1,0,0,0,1}, 2);
        assertEquals(false, actual);
    }

    @Test
    public void test_3() {
        boolean actual = new Solution().canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2);
        assertEquals(false, actual);
    }

    @Test
    public void test_4() {
        boolean actual = new Solution().canPlaceFlowers(new int[]{1,0,1,0,1,0,1}, 0);
        assertEquals(true, actual);
    }

}