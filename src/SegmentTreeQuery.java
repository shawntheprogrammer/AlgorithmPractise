
public class SegmentTreeQuery {
     public class SegmentTreeNode {
         public int start, end, max;
         public SegmentTreeNode left, right;
         public SegmentTreeNode(int start, int end, int max) {
             this.start = start;
             this.end = end;
             this.max = max;
             this.left = this.right = null;
         }
     }
    
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        //invalid input
        if (start > end || start < root.start || end > root.end) {
            return Integer.MIN_VALUE;
        }
        int mid = (root.start + root.end) / 2;
        //exact match
        if (start == root.start && end == root.end) {
            return root.max;
        }
        //result on root'left subtree
        if (end <= mid) {
            return query(root.left, start, end);
        }
        //result on root's right subtree
        if (start > mid) {
            return query(root.right, start, end);
        }
        //result is the max of left subtree and right subtree
        return Math.max(query(root.left, start, mid), query(root.right, mid + 1, end));
    }
    
    /**
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root.start == index && root.end == index) {
            root.max = value;
            return;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        root.max = Math.max(root.max, value);
        
        //go to left subtree or right subtree
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        root.max = Math.max(root.left.max, root.right.max);
    }
}
