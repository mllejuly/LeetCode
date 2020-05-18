/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Recursion
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode evenHead = head.next;
        head.next = swapPairs(head.next.next);
        evenHead.next = head;
        
        return evenHead;
        
    }
}

// time : O(n)
// space: O(n)

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Iteration
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        
        while (head != null && head.next != null) {
            ListNode oddNode = head;
            ListNode evenNode = head.next;
            
            // swap
            cur.next = evenNode;
            oddNode.next = evenNode.next;
            evenNode.next = oddNode;
            
            cur = oddNode;
            head = oddNode.next;
        }
        
        return dummyHead.next;
    }
}

// time : O(n)
// space: O(1)


