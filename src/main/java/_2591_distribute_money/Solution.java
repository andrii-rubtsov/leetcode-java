/**
 * 2591. Distribute Money to Maximum Children
 * https://leetcode.com/contest/biweekly-contest-100/problems/distribute-money-to-maximum-children/
 */
package _2591_distribute_money;

import java.util.*;

public class Solution {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        int leftover = money - children;
        if (leftover <= 0) {
            return 0;
        }
        int full = leftover / 7;
        if (full == 0) {
            return 0;
        }

        int rem = leftover % 7;
        if (full == children) {
            if (rem == 0) {
                return full;
            } else {
                return full - 1;
            }
        }
        if (full > children) {
            return children - 1;
        }
        if (rem == 3 && (children - full) == 1) {
            return children - 2;
        }
        return  full;
    }
}