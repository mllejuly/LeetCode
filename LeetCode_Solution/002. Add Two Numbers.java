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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        ListNode node1 = l1;
        ListNode node2 = l2;
        
        int carry = 0;
        while (node1 != null || node2 != null) {
            int digit1 = node1 != null ? node1.val : 0;
            int digit2 = node2 != null ? node2.val : 0;
            int digitSum = digit1 + digit2 + carry;
            
            cur.next = new ListNode(digitSum % 10);
            cur = cur.next;
            carry = digitSum / 10;
            
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
}


// time : O(max(m,n))
// space: O(max(m,n))



//////////////////////////////////////////////////////////////////////////////////////

// 分析:
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
