/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 1. 设置dummyHead
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // 2. 碰到目标 val 走两步，否则走一步
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}
