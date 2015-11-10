
public class IntervalSumII {
    /* you may need to use some attributes here */
    public class SegmentTreeNode {
        public SegmentTreeNode left, right;  //left child and right child nodes
        public int start, end;  //starting index and ending index
        public long sum;  
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    SegmentTreeNode root;  //the root of the segment tree
    
    /**
     * @param A: An integer array
     */
    public IntervalSumII(int[] A) {
        //build up a segment tree
        root = build(A, 0, A.length - 1);
    }
    
    /**
     * @param int[] A: An integer array where we build a segment tree from
     * @param int start: the starting index of this returned node's starting index in the array
     * @param int end: the ending index of this returned node's ending index in the array
     * return : a SegmentTreeNode 
     */
    public SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        //base case: leaf nodes where start == end
        if (start == end) {
            node.sum = (long)A[start];
            return node;
        }
        int mid = (start + end) / 2;
        node.left = build(A, start, mid);
        node.right = build(A, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        if (start > end || root == null || end < root.start || start > root.end) {
            return 0;
        }
        return query(root, start, end);
        
    }
    
    public long query(SegmentTreeNode node, int start, int end) {
        start = Math.max(node.start, start);
        end = Math.min(node.end, end);
        int mid = (node.start + node.end) / 2;
        //exact match
        if (start == node.start && end == node.end) {
            return node.sum;
        }
        //on left subtree
        if (end <= mid) {
            return query(node.left, start, end);
        }
        // on right subtree
        if (start > mid) {
            return query(node.right, start, end);
        }
        //on left & right subtree
        if (start <= mid && end > mid) {
            return query(node.left, start, mid) + query(node.right, mid + 1, end);
        }
        return 0;
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        if (root == null || index > root.end || index < root.start) {
            return;
        }
        modify(root, index, (long)value);
    }
    
    //return the difference original sum - current sum
    public long modify(SegmentTreeNode node, int index, long value) {
        //find the leaf node
        if (node.start == index && node.end == index) {
            node.sum = value;
            return node.sum;
        }
        //change sum on path from root to leaf node
        int mid = (node.start + node.end) / 2;
        //on left subtree
        if (index <= mid) {
            node.sum = modify(node.left, index, value) + node.right.sum;
        } else {
            node.sum = modify(node.right, index, value) + node.left.sum;
        }
        return node.sum;
    }
}
