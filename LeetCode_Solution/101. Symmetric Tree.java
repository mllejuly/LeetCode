/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 递归,Depth-first Search,Bloomberg,二叉树,领英,微软,Breadth-first Search
// Recursive
// Time complexity : O(n). Because we traverse the entire input tree once
// Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n).

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        
        if (t1 == null || t2 == null) {
            return false;
        }
        
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
        
    }
}
