/**
 * 1472. Design Browser History
 * https://leetcode.com/problems/design-browser-history/
 */
package _1472_design_browser_history;

import java.util.*;

public class Solution {
}

class BrowserHistory {

    List<String> history = new ArrayList<>();
    int idx = -1;

    public BrowserHistory(String homepage) {
        this.visit(homepage);
    }

    public void visit(String url) {
        while (this.history.size() > this.idx + 1) {
            this.history.remove(this.history.size() - 1);
        }
        this.history.add(url);
        this.idx++;
    }

    public String back(int steps) {
        this.idx = Math.max(0, this.idx - steps);
        return this.history.get(this.idx);
    }

    public String forward(int steps) {
        this.idx = Math.min(this.history.size() - 1, this.idx + steps);
        return this.history.get(this.idx);
    }
}
