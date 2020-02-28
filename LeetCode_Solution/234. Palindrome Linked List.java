/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 脸书,亚马逊,链表,IXL

class Solution {
    public boolean isPalindrome(ListNode head) {
        // 设置快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        
        // 快指针一次走两格，慢指针一次走一格
        // 因此快指针走完链表的时候，慢指针刚好走到链表中间，获得后半截链表
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
        }
        
        // 此时反转慢指针的链表
        // 快指针首元结点回到head
        slow = reverse(slow);
        fast = head;
        
        // 如果是对称链表，slow后半截链表反转后变成前半截链表，当和fast链表每个节点都一样
        while (slow != null) {
            // 不一样返回false
            if (slow.val != fast.val) {
                return false;
            }
            // 此时slow fast步伐一致
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    // 定义helper reverse with O(1)
    // refer to LeetCode 206. Reverse Linked List
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
}
