/**
 * 983. Minimum Cost For Tickets
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
package _983_minimum_cost_for_tickets;


import java.util.Arrays;

class Solution {

    int[] costs;
    int[] days;
    int[] cache;
    int n;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        cache = new int[366];
        Arrays.fill(cache, -1);
        this.days = days;
        this.n = days.length;
        return move(0, 0, 0);
    }

    int move(int startDayIdx, int paidForDays, int costSoFar) {
        if (startDayIdx >= n || days[startDayIdx] + paidForDays - 1 >= days[days.length - 1]) {
            return costSoFar;
        }
        int nextUnpaidDayIdx = startDayIdx;
        while (nextUnpaidDayIdx < n && days[nextUnpaidDayIdx] < days[startDayIdx] + paidForDays) {
            nextUnpaidDayIdx++;
        }
        int downstreamResult;
        if (cache[nextUnpaidDayIdx] != -1) {
            downstreamResult = cache[nextUnpaidDayIdx];
        } else {
            downstreamResult = Math.min(
                    move(nextUnpaidDayIdx, 1, costs[0]),
                    Math.min(
                            move(nextUnpaidDayIdx, 7, costs[1]),
                            move(nextUnpaidDayIdx, 30, costs[2])
                    )
            );
        }
        cache[nextUnpaidDayIdx] = downstreamResult;
        return downstreamResult + costSoFar;
    }

}