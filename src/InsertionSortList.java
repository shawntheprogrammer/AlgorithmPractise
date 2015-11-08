
public class InsertionSortList {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        //make a fake head
        ListNode fake = new ListNode(Integer.MIN_VALUE);
        
        ListNode cur = head;
        while (cur != null) {
            ListNode nextCur = cur.next;
            
            //find a pos in the ordered list
            ListNode before = fake;
            ListNode after = fake.next;
            //stop condition : after == null || cur.val <= after.val
            while (after != null && cur.val > after.val) {
                before = before.next;
                after = after.next;
            }
            //connect
            before.next = cur;
            cur.next = after;
            
            cur = nextCur;
        }
        
        return fake.next;
    }
}
