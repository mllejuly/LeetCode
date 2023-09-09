/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
// Brute Force
// Time complexity : O(mn)
// Space complexity : O(1)
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1.
        ListNode a = headA;
        ListNode b;
        
        // 2.
        while (a != null) {
            for (b = headB; b != null; b = b.next) {
                if (a == b) {
                    return a;
                }
            }
            a = a.next;
        }
        
        // 3.
        return null;
    }
}



// Two Pointers
// Time complexity : O(m+n)
// Space complexity : O(1)
public class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        
        return a;
        
    }
}
