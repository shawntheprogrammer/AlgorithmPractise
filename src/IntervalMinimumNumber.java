import java.util.*;

public class IntervalMinimumNumber {
    public class Interval {
         int start, end;
         Interval(int start, int end) {
              this.start = start;
              this.end = end;
         }
    }
    
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        if (A == null || queries == null) {
            return new ArrayList<Integer>();
        }
        //build up a segment tree
        SegmentTreeNode root = build(A, 0, A.length - 1);
        
        //return list
        ArrayList<Integer> result = new ArrayList<>();
        for (Interval interval : queries) {
            int min = getMinimum(root, interval.start, interval.end);
            result.add(min);
        }
        return result;
    }
    
    public class SegmentTreeNode{
        public SegmentTreeNode left, right;
        public int start, end, min;
        public SegmentTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
        }
    }
    
    public SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
        //base case : leaf nodes
        if (start == end) {
            return node;
        }
        int mid = start + (end - start) / 2;
        //build up subtrees
        node.left = build(A, start, mid);
        node.right = build(A, mid + 1, end);
        node.min = Math.min(node.left.min, node.right.min);
        return node;
    }
    
    
    public int getMinimum(SegmentTreeNode node, int start, int end) {
        //invalid queriey
        if (node == null || start > end || start > node.end || end < node.start) {
            return 0;
        }
        start = Math.max(node.start, start);
        end = Math.min(node.end, end);
        int mid = (node.start + node.end) / 2;
        //exact match
        if (node.start == start && node.end == end) {
            return node.min;
        }
        //three conditions 
        // 1. on left subtree exclusively
        if (end <= mid) {
            return getMinimum(node.left, start, end);
        // 2. on right subtree exclusively
        } else if (start > mid) {
            return getMinimum(node.right, start, end);
        // 3. on left and right, return compared minimum    
        } else {
            return Math.min(getMinimum(node.left, start, mid), getMinimum(node.right, mid + 1, end));
        }
    }
}
