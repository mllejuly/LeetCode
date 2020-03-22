//////////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummyHead;
        
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            
        }
        
        return dummyHead.next;
        
    }
}
//////////////////////////////////////////////////////////////////////////////////////


// 需要考虑的3种edge case
// 1. 两个链表的长度不一样长
// 2. 其中一个链表长度为空
// 3. 结果链表存在进位

// Time complexity : O(max(m,n)). 
// m : length of l1
// n : length of l2

// Space complexity : O(max(m,n)). 
// The length of the new list is at most max(m,n)+1.

// Tag: Bloomberg, 高精度, Adobe, 微软, 爱彼迎, 链表, 亚马逊
// Cracking The Coding Interview, Chapter 2, 2.5
