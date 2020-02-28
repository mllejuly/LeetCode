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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // recursion
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        
        // swap
        root.left = right;
        root.right = left;
        
        // return
        return root;
    }
}
