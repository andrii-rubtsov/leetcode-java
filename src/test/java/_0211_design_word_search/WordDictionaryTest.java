package _0211_design_word_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordDictionaryTest {
    @Test
    void test_0() {
        WordDictionary d = new WordDictionary();
        // ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        d.addWord("bad");
        d.addWord("dad");
        d.addWord("mad");

        assertEquals(false, d.search("pad"));
        assertEquals(true, d.search("bad"));
        assertEquals(true, d.search(".ad"));
        assertEquals(true, d.search("b.."));
    }
}