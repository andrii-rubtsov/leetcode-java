package _0071_simplify_path;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test_0() {
        String actual = new Solution().simplifyPath(
                "/home/"
        );
        assertEquals("/home", actual);
    }

    @Test
    public void test_1() {
        String actual = new Solution().simplifyPath(
                "/home//foo/"
        );
        assertEquals("/home/foo", actual);
    }

    @Test
    public void test_2() {
        String actual = new Solution().simplifyPath(
                "/../"
        );
        assertEquals("/", actual);
    }

    @Test
    public void test_3() {
        String actual = new Solution().simplifyPath(
                "/a//b////c/d//././/.."
        );
        assertEquals("/a/b/c", actual);
    }

}