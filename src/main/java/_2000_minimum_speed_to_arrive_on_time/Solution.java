/**
 * 2000. Minimum Speed to Arrive on Time
 * https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
 */
package _2000_minimum_speed_to_arrive_on_time;


import java.util.Arrays;

class Solution {

    int[] dist;
    double timeBudget;

    public int minSpeedOnTime(int[] dist, double hour) {
        this.dist = dist;
        this.timeBudget = hour;

        double maxTimeForLastSegment = timeBudget - (dist.length - 1);
        if (maxTimeForLastSegment <= 0) {
            return -1;
        }
        int maxDist = Arrays.stream(dist).max().getAsInt();
        int speedToTravelLastSegmentInTime = (int) Math.ceil(dist[dist.length - 1] / maxTimeForLastSegment);
        int maxSpeed = Math.max(maxDist, speedToTravelLastSegmentInTime);

        return this.findMinimalSpeed(1, maxSpeed);
    }

    private int findMinimalSpeed(int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;

        double travelTime = calcTravelTime(mid);
        if (travelTime == this.timeBudget) {
            return mid;
        } else if (travelTime < this.timeBudget) {
            return findMinimalSpeed(left, mid);
        } else {
            return findMinimalSpeed(mid + 1, right);
        }
    }

    private double calcTravelTime(int speed) {
        double time = 0.0;
        for (int i = 0; i < this.dist.length; i++) {
            if (i < this.dist.length - 1) {
                int travel_hours = this.dist[i] / speed;
                if (this.dist[i] % speed > 0) {
                    travel_hours += 1;
                }
                time += travel_hours;
            } else {
                time += (1.0 * this.dist[i] / speed);
            }
        }
        return time;
    }

}