/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 */
package _0071_simplify_path;


import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String simplifyPath(String path) {
        if (path.charAt(0) != '/') {
            throw new IllegalArgumentException("The path must start with '/'");
        }
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        LinkedList<String> stack = new LinkedList<>();
        int currSlashIdx = 0;
        int nextSlashIdx;
        while ((nextSlashIdx = path.indexOf('/', currSlashIdx + 1)) > 0) {
            String subPath = path.substring(currSlashIdx + 1, nextSlashIdx);
            currSlashIdx = nextSlashIdx;
            if (subPath.isEmpty()) {
                // Double slash found, ignore and treat like a single slash
                continue;
            }
            if (subPath.equals("..")) {
                // Goes above cur level to parent by removing the last element
                stack.pollLast();
            } else if (!subPath.equals(".")) {
                stack.add(subPath);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        return stack.stream().map(elem -> "/" + elem).collect(Collectors.joining());
    }
}