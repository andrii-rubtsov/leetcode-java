package common;

import java.util.*;

public abstract class TreeUtils {

    public static String serialize(TreeNode root) {
        Queue<Optional<TreeNode>> queue = new ArrayDeque<>();
        queue.add(Optional.ofNullable(root));
        List<String> values = new ArrayList<>();

        while (!queue.isEmpty()) {
            Optional<TreeNode> maybeElem = queue.remove();
            if (maybeElem.isPresent()) {
                TreeNode elem = maybeElem.get();
                values.add(String.valueOf(elem.val));
                queue.add(Optional.ofNullable(elem.left));
                queue.add(Optional.ofNullable(elem.right));
            } else {
                values.add(null);
            }
        }
        while (values.size() > 0 && values.get(values.size() - 1) == null) {
            values.remove(values.size() - 1);
        }
        return "[" + String.join(",", values) + "]";
    }

}
