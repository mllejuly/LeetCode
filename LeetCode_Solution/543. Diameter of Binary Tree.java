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
    
    // tag: 脸书,二叉树,二叉树遍历,谷歌
    
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        // 5. 调用helper
        maxDepth(root);
        return max;
    }
    
    // helper
    private int maxDepth(TreeNode root) {
        // 0. 树为空，返回 0
        if (root == null ) {
            return 0;
        }
        
        // 1. 左子树最大深度
        int left = maxDepth(root.left);
        
        // 2. 右子树最大深度
        int right = maxDepth(root.right);
        
        // 3. 比较历史最大直径 max ，和当前最大直径 的更大值
        // 左右子树深度之和 为当前最大直径
        max = Math.max(max, left + right);
        
        // 4. 递归得到子树的最大直径, 加上根节点的深度 1，即为当前BST的最大深度
        return Math.max(left, right) + 1;
    }
}
