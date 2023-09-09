/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n).
// Space complexity : O(1).

class Solution {
    
    // Iteration
    
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        
        // while traversing the list, change the current node's next pointer to point to its previous element
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}





