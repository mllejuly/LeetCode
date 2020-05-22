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


// Inorder Traversal
// always choose left middle nodes as a root
class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    
    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        
        int rootPos = (l + r) / 2;
        TreeNode root = new TreeNode(nums[rootPos]);
        root.left = helper(nums, l, rootPos - 1);
        root.right = helper(nums, rootPos + 1, r);
        return root;
    }
    
}


// time : O(n)
// space: O(n)
