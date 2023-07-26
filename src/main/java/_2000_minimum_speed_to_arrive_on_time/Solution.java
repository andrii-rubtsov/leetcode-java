/**
 * 2000. Minimum Speed to Arrive on Time
 * https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
 */
package _2000_minimum_speed_to_arrive_on_time;


import java.util.Arrays;

class Solution {

    int[] dist;

    public int minSpeedOnTime(int[] dist, double timeBudget) {
        this.dist = dist;

        double maxTimeForLastSegment = timeBudget - (dist.length - 1);
        if (maxTimeForLastSegment <= 0) {
            return -1;
        }
        int maxDist = Arrays.stream(dist).max().orElseThrow();
        int speedToTravelLastSegmentInTime = (int) Math.ceil(dist[dist.length - 1] / maxTimeForLastSegment);
        int maxSpeed = Math.max(maxDist, speedToTravelLastSegmentInTime);

        int left = 1;
        int right = maxSpeed;
        while (left != right) {
            int mid = (left + right) / 2;
            double travelTime = calcTravelTime(mid);
            if (travelTime == timeBudget) {
                return mid;
            } else if (travelTime < timeBudget) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private double calcTravelTime(int speed) {
        int totalTime = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            // The trick with extra `speed - 1` is to add `1` if the division's remainder was > 0
            totalTime += (dist[i] + (speed - 1)) / speed;
        }
        return totalTime + (1.0 * dist[dist.length - 1] / speed);
    }

}