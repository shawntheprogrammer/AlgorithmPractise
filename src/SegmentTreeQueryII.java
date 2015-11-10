
public class SegmentTreeQueryII {
     public class SegmentTreeNode {
         public int start, end, count;
         public SegmentTreeNode left, right;
         public SegmentTreeNode(int start, int end, int count) {
             this.start = start;
             this.end = end;
             this.count = count;
             this.left = this.right = null;
         }
     }

    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        //invalid input as no overlapping
        if (root == null || start > root.end || end < root.start || start > end) {
            return 0;
        }
        //base case: exact match
        if (start == root.start && end == root.end) {
            return root.count;
        }
        start = Math.max(root.start, start);
        end = Math.min(root.end, end);
        int mid = (root.start + root.end) / 2;
        //three conditions: 
        //1. on root's leftsubtree exclusively
        if (end <= mid) {
            return query(root.left, start, end);
        }
        //2. on root's right subtree exclusively
        if (start > mid) {
            return query(root.right, start, end);
        }
        //3. partially left and right
        if (start <= mid && end > mid) {
            return query(root.left, start, mid) + query(root.right, mid + 1, end);
        }
        return 0;
    }
}
