/**
 * 605. Can Place Flowers
 * https://leetcode.com/problems/can-place-flowers/
 */
package _0605_can_place_flowers;

public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int len = flowerbed.length;

        // mark adjacent with `-1`
        for (int i = 0; i <len; i++) {
            if (flowerbed[i] == 1) {
                if (i > 0 && flowerbed[i-1] == 0) {
                    flowerbed[i-1] = -1;
                }
                if (i < len-1 && flowerbed[i+1] == 0) {
                    flowerbed[i+1] = -1;
                }
            }
        }

        // `plant` trees in free slots
        int left = n;
        for (int i = 0; i <len; i++) {
            if (flowerbed[i] == 0) {
                flowerbed[i] = 1;
                left--;
                if (left == 0) {
                    return true;
                }
                if (i < len-1 && flowerbed[i+1] == 0) {
                    flowerbed[i+1] = -1;
                }
            }
        }

        return false;
    }

}
