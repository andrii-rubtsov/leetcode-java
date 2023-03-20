/**
 * 2594. Minimum Time to Repair Cars
 * https://leetcode.com/contest/biweekly-contest-100/problems/minimum-time-to-repair-cars/
 */

package _2594_minimum_time_to_repair_cars;

import java.util.*;

public class Solution {

    record TimeIdx (int idx, long time) {}

    public long repairCars(int[] ranks, int carsNum) {
        int n = ranks.length;

        Arrays.sort(ranks);
        int[] cars = new int[n];

        long curMaxTime = ranks[0];
        cars[0]++;

        for (int car = 1; car < carsNum; car++) {
            for (int rankIdx = 0; rankIdx < n; rankIdx++) {
                long newTime = ranks[rankIdx] * ( (cars[rankIdx] + 1L) *  (cars[rankIdx] + 1L));
                if (newTime < curMaxTime) {
                    cars[rankIdx]++;
                    continue;
                }
            }
            cars[0]++;
            // TODO
            //curMaxTime
        }

        return curMaxTime;

    }
}