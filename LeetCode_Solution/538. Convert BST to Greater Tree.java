/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    
    // global variable
    int sum = 0;
    
    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        dfs(cur.right);
        sum += cur.val;
        cur.val = sum;
        dfs(cur.left);
        
    }
    
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
}
