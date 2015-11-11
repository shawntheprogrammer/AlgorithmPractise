import java.util.*;

public class ConvertBinarySearchTreetoDoublyLinkedList {
    
     public class DoublyListNode {
             int val;
             DoublyListNode next, prev;
             DoublyListNode(int val) {
                 this.val = val;
                 this.next = this.prev = null;
             }
         }
    
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if (root == null) {
            return null;
        }
        
        //using a stack in-order traverse the tree
        //stack is the path to the currently unvisited smallest node
        Stack<TreeNode> stack = new Stack<>();
        //a fake node
        DoublyListNode prev = new DoublyListNode(0);
        DoublyListNode result = prev;
        //cur is the next node to expand the path
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            //expand the path to the current unvisited smallest node
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            //construct new DoublyListNode and connext
            DoublyListNode dnode = new DoublyListNode(node.val);
            dnode.prev = prev;
            prev.next = dnode;
            prev = dnode;
            
            cur = node.right;
        }
        result.next.prev = null;
        return result.next;
    }
}
