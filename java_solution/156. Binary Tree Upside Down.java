/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Recursion
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        return upsideDown(root);
    }
    
    private TreeNode upsideDown(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        
        TreeNode newRoot = upsideDown(node.left);
        node.left.right = node;
        node.left.left = node.right;
        node.left = null;
        node.right = null;
        return newRoot;
    }
}


// time : O(n)
// space: O(log n)
