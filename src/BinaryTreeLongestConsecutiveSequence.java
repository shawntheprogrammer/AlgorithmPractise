
public class BinaryTreeLongestConsecutiveSequence {
    public int longest = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        lc(root);
        return longest;
    }
    
    public int lc(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = lc(root.left);
        int right = lc(root.right);
        int result = 1;
        if (left != 0 && root.val == root.left.val - 1) {
            result = left + 1;
        }
        if (right != 0 && root.val == root.right.val - 1) {
            result = Math.max(result, right + 1);
        }
        longest = Math.max(longest, result);
        return result;
    }
}
