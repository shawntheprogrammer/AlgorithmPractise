
public class IntersectionofTwoLinkedLists {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA == null || headB == null) {
            return null;
        }
        //get the number of nodes in list A
        int numA = 0;
        ListNode cur = headA;
        while (cur != null) {
            cur = cur.next;
            numA++;
        }
        
        //get the number of nodes in list B
        int numB = 0;
        cur = headB;
        while (cur != null) {
            cur = cur.next;
            numB++;
        }
        
        ListNode curA = headA;
        ListNode curB = headB;
        //make the longer list's cur move |numA - numB| steps
        for (int i = 0; i < numA - numB; i++) {
            curA = curA.next;
        }
        for (int i = 0; i < numB - numA; i++) {
            curB = curB.next;
        }
        
        //move them one step at a time together until they meet
        //also need to be aware that they might not intersect
        while (curA != curB && curA != null) {
            curA = curA.next;
            curB = curB.next;
        }
        
        return curA;
    }  
}
