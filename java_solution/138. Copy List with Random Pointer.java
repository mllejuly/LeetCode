/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

public class Solution {    
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap();
        
        Node cur = head;
        // copy node
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        
        // copy pointers
        cur = head;
        while(cur != null) {
            // copy next pointer for cur node
            map.get(cur).next = map.get(cur.next);
            // copy random pointer for cur node
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        
        return map.get(head);
    }
}

// time : O(n)
// space: O(n)

//////////////////////////////////////////////////////////////////////////////
/*
分析
        ————————→
———————→
1 → 2 → 3 → 4 → 5
 ←———    ←———
    ←————————————

0. coner case

1. 检查 node 1 是否被 copy 过，如果没有则 copy 一份存入 hashmap 
                                                      key : 保存原链表 node 
                                                      val : 新链表 node
                                                      
2. copy的 node 加入 new list， 即 copy 此 node 的固有指针
3. copy 此 node 的 random 指针
4. 对原链表所有 node 执行上述操作

*/
