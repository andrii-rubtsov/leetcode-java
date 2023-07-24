package common;

import common.TreeNode;
import common.TreeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeUtilsTest {

    @Test
    public void testSerialization_0() {
        String actual = TreeUtils.serialize(null);
        assertEquals("[]", actual);
    }

    @Test
    public void testSerialization_1() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3)
        );

        String actual = TreeUtils.serialize(root);
        assertEquals("[1,2,3]", actual);
    }

    @Test
    public void testSerialization_2() {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3),
                        null
                )
        );

        String actual = TreeUtils.serialize(root);
        assertEquals("[1,null,2,3]", actual);
    }

    @Test
    public void testSerialization_3() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(3, new TreeNode(-1), null),
                        null
                ),
                new TreeNode(7,
                        new TreeNode(2, new TreeNode(9), null),
                        null
                )
        );

        String actual = TreeUtils.serialize(root);
        assertEquals("[5,4,7,3,null,2,null,-1,null,9]", actual);
    }

}