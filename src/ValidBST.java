import java.util.*;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //a path to the undiscovered min node
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        long min = (long)Integer.MIN_VALUE - 1;
        //find the current undiscovered min node and check its value
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode currentMin = stack.pop();
            if ((long)currentMin.val <= min) {
                return false;
            }
            min = (long)currentMin.val;
            cur = currentMin.right;
        }
        return true;
    }
}
