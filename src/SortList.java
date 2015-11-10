
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //get the number of nodes in the list
        int num = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            num++;
        }
        
        //split in two
        cur = head;
        for (int i = 0; i < (num - 1)/2; i++) {
            cur = cur.next;
        }
        ListNode head2 = sortList(cur.next);
        cur.next = null;
        ListNode head1 = sortList(head);
        return merge(head1, head2);
    }
    
    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        //a return fake head
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        //merge up
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        
        // add the rest
        while (h1 != null) {
            cur.next = h1;
            cur = cur.next;
            h1 = h1.next;
        }
        while (h2 != null) {
            cur.next = h2;
            cur = cur.next;
            h2 = h2.next;
        }
        return fakeHead.next;
    } 
}
