/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


// To detect if a list is cyclic, we can check whether a node had been visited before. 
// A natural way is to use a hash table.

// Time complexity : O(n). 
// We visit each of the n elements in the list at most once. Adding a node to the hash table costs only O(1) time.

// Space complexity: O(n). 
// The space depends on the number of elements added to the hash table, which contains at most n elements.

public class Solution {
    public boolean hasCycle(ListNode head) {
        // 1.
        Set<ListNode> nodeSet = new HashSet<>();
        
        // 2.
        while (head != null) {
            if (nodeSet.cotains(head)) {
                return ture;
            }
            else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        
        // 3. 访问完List依然没有出现访问过的节点，说明链表没有circle，返回 F
        return false;
    }
}
