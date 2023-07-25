/**
 * 882. Peak Index in a Mountain Array
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
package _0882_peak_index_in_a_mountain_array;


class Solution {
    int[] arr;

    public int peakIndexInMountainArray(int[] arr) {
        this.arr = arr;
        return findPeek(1, arr.length - 2);
    }

    int findPeek(int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (arr[mid] < arr[mid + 1]) {
            return findPeek(mid + 1, right);
        } else {
            return findPeek(left, mid - 1);
        }
    }

}