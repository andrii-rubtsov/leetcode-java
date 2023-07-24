package _0930_all_possible_full_binary_trees;

import common.TreeNode;
import common.TreeUtils;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test_0() {
        List<TreeNode> actual = new Solution().allPossibleFBT(7);
        HashSet<String> actualSerialized = new HashSet<>(actual.stream().map(TreeUtils::serialize).toList());
        HashSet<String> expectedSerialized = new HashSet<>(List.of(
                "[0,0,0,0,0,0,0]",
                "[0,0,0,0,0,null,null,0,0]",
                "[0,0,0,0,0,null,null,null,null,0,0]",
                "[0,0,0,null,null,0,0,0,0]",
                "[0,0,0,null,null,0,0,null,null,0,0]"
        ));
        assertEquals(expectedSerialized.size(), actual.size());
        assertEquals(expectedSerialized, actualSerialized);
    }

    @Test
    public void test_1() {
        List<TreeNode> actual = new Solution().allPossibleFBT(3);
        HashSet<String> actualSerialized = new HashSet<>(actual.stream().map(TreeUtils::serialize).toList());
        HashSet<String> expectedSerialized = new HashSet<>(List.of(
                "[0,0,0]"
        ));
        assertEquals(expectedSerialized.size(), actual.size());
        assertEquals(expectedSerialized, actualSerialized);
    }

    @Test
    public void test_2() {
        List<TreeNode> actual = new Solution().allPossibleFBT(1);
        HashSet<String> actualSerialized = new HashSet<>(actual.stream().map(TreeUtils::serialize).toList());
        HashSet<String> expectedSerialized = new HashSet<>(List.of(
                "[0]"
        ));
        assertEquals(expectedSerialized, actualSerialized);
    }

}