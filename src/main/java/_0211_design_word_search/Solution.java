/**
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
package _0211_design_word_search;

import java.util.*;

public class Solution {
}

class TrieNode {

    static Character ANY_CHAR = '.';

    boolean isTerminating = false;
    HashMap<Character, TrieNode> children = new HashMap<>();

    Optional<TrieNode> getChild(char c) {
        return Optional.ofNullable(children.get(c));
    }

}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
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
        return this.checkIfPresent(this.root, word);
    }

    private boolean checkIfPresent(TrieNode start, String postfix) {
        if (postfix.isEmpty()) {
            return start.isTerminating;
        }
        char c = postfix.charAt(0);
        String rem = postfix.substring(1);
        if (c != TrieNode.ANY_CHAR) {
            Optional<TrieNode> child = start.getChild(c);
            if (child.isEmpty()) {
                return false;
            }
            return this.checkIfPresent(child.get(), rem);
        } else {
            for (TrieNode n : start.children.values()) {
                if (this.checkIfPresent(n, rem)) {
                    return true;
                }
            }
            return false;
        }

    }
}

