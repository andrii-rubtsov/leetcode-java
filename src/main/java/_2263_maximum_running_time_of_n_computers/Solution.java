/**
 * 2263. Maximum Running Time of N Computers
 * https://leetcode.com/problems/maximum-running-time-of-n-computers/
 */
package _2263_maximum_running_time_of_n_computers;


class Solution {

    int[] batteries;
    int laptopsCount;

    public long maxRunTime(int laptopsCount, int[] batteries) {
        this.batteries = batteries;
        this.laptopsCount = laptopsCount;

        long left = 1;
        long right = 0;
        for (int b : batteries) {
            right += b;
        }
        right /= laptopsCount;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    private boolean check(long time) {
        long res = 0;
        for (int b : batteries) {
            res += Math.min(b, time);
        }
        return res >= time * laptopsCount;
    }

}