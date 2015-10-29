/*
 * You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. 
 * Create an algorithm to decide if T2 is a subtree of T1.
 */

public class Subtree {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        //return true if T2 is null
        if (T2 == null) {
            return true;
        }
        //return false if T1 is null
        if (T1 == null) {
            return false;
        }
        if (isSameTree(T1, T2)) {
            return true;
        } else {
            return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
        }
    }
    
    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null || n1.val != n2.val) {
            return false;
        }
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}
