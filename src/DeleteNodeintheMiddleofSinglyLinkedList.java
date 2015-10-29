
public class DeleteNodeintheMiddleofSinglyLinkedList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
       }
     }
    
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null || node.next == null) {
            return;
        }
        //swap cur's value with cur.next's value
        ListNode cur = node;
        ListNode next = cur.next;
        while (next != null) {
            if (next.next == null) {
                cur.val = next.val;
                cur.next = null;
                break;
            }
            cur.val = next.val;
            cur = cur.next;
            next = next.next;
        }
    }
}