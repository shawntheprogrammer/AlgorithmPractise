
public class SegmentTreeBuild {
    public class SegmentTreeNode {
      public int start, end;
      public SegmentTreeNode left, right;
      public SegmentTreeNode(int start, int end) {
          this.start = start;
          this.end = end;
          this.left = this.right = null;
      }
   };

    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start == end) {
            return new SegmentTreeNode(start, end);
        }
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        int mid = (start + end) / 2;
        node.left = build(start, mid);
        node.right = build(mid + 1, end);
        return node;
    };
}
