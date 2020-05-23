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
    
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = Math.max(maxGain(node.left), 0);
        int rightSum = Math.max(maxGain(node.right), 0);
        maxSum = Math.max(node.val + leftSum + rightSum, maxSum);
        
        return node.val + Math.max(leftSum, rightSum);
        
    }
}


// time : O(n)
// space: O(log n), recursion stack of tree height
