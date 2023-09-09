/////////////////////////////////////////////////////////////////////////////////////////////////////////
/**

23. Merge k Sorted Lists
Hard

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
**/

/////////////////////////////////////////////////////////////////////////////////////////////////////////

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

// MergeSort | Divide and Conquer
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return mergeKLists(lists, 0, lists.length - 1);
    }
    
    
    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        } else if (l < r) {
            int mid = l + (r - l) / 2;
            ListNode leftList = mergeKLists(lists, l, mid);
            ListNode rightList = mergeKLists(lists, mid + 1, r);
            return mergeTwoLists(leftList, rightList);
        }    
        return null;
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        
        return dummyHead.next;
    }
    
}


// time : O(n log k)
// space: O(1)
