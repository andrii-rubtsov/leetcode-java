/**
 * 826. Soup Servings
 * https://leetcode.com/problems/soup-servings/
 */
package _0826_soup_servings;

class Solution {

    double[][] cache;

    public double soupServings(int n) {
        if (n >= 4800) {
            // Lifesaving trick/observation: as n is larger the result is getting close to 1.
            return 1;
        }
        int len = (n + 25 - 1) / 25;
        this.cache = new double[len + 1][];

        for (int i = 0; i <= len; i++) {
            cache[i] = new double[len + 1];
        }
        return getProbability(len, len);
    }

    private double getProbability(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        } else if (a <= 0) {
            return 1;
        } else if (b > 0) {
            double result = cache[a][b];
            if (result == 0) {
                result += this.getProbability(a - 4, b);
                result += this.getProbability(a - 3, b - 1);
                result += this.getProbability(a - 2, b - 2);
                result += this.getProbability(a - 1, b - 3);
                result /= 4;
                cache[a][b] = result;
            }
            return result;
        } else {
            return 0;
        }
    }

}