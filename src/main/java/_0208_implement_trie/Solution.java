/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
package _0208_implement_trie;

import java.util.*;

public class Solution {
}


class TrieNode {

    boolean isTerminating = false;
    HashMap<Character, TrieNode> children = new HashMap<>(26);

    Optional<TrieNode> getChild(char c) {
        return Optional.ofNullable(children.get(c));
    }

}

class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode prev = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode n;
            if (prev.children.containsKey(c)) {
                n = prev.children.get(c);
            } else {
                n = new TrieNode();
                prev.children.put(c, n);
            }
            prev = n;
        }
        prev.isTerminating = true;
    }

    public boolean search(String word) {
        return this.checkIfPresent(word, true);
    }

    public boolean startsWith(String prefix) {
        return this.checkIfPresent(prefix, false);
    }

    public boolean checkIfPresent(String prefix, boolean requireTermination) {
        TrieNode prev = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Optional<TrieNode> child = prev.getChild(c);
            if (child.isEmpty()) {
                return false;
            }
            prev = child.get();
        }
        return !requireTermination || prev.isTerminating;
    }
}


