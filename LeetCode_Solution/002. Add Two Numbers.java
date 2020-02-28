/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// Tag: Bloomberg, 高精度, Adobe, 微软, 爱彼迎, 链表, 亚马逊
// Cracking The Coding Interview, Chapter 2, 2.5

// 需要考虑的3种edge case
// 1. 两个链表的长度不一样长
// 2. 其中一个链表长度为空
// 3. 结果链表存在进位

// Time complexity : O(max(m,n)). 
// Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above iterates at most max(m,n) times.

// Space complexity : O(max(m,n)). 
// The length of the new list is at most max(m,n)+1.
    
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1, l2 尽量不要直接移动
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        int sum = 0;
        
        while (p1 != null || p2 != null) {
            
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            
            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
        }
        
        // 最后的进位
        if (sum != 0) {
            curr.next = new ListNode(sum);
        }
        
        return dummy.next;
    }
}

