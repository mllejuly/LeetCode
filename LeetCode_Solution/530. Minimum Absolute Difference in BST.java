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
    // Tag: 谷歌, 二叉查找树, 二叉树遍历, 二叉搜索树
    // 给定具有非负值的二叉搜索树，找到任意两个节点的值之间的最小绝对差值
    public int getMinimumDifference(TreeNode root) {
        
        // 创建一个名为numsList的动态数组储存BST中序遍历的结果
        List<Integer> numsList = new ArrayList<Integer>();
        
        // 对BST所有节点进行中序遍历
        inTraversal(root, numsList);
        
        // 创建一个整数列表储存结果，列表的大小为之前创建的numsList的大小
        Integer[] nums = new Integer[numsList.size()];
        
        // 将动态数组numsList转化为数组nums
        numsList.toArray(nums);
        
        
        // 用ans储存数组中前两个数的差值
        int ans = nums[1] - nums[0];
        
        // 遍历此升序数组nums，如果出现相邻两个数的差值小于ans初始值，则更新此差值最小值ans
        for (int i = 2; i < nums.length; ++i) {
            ans = Math.min(ans, nums[i] - nums[i-1]);
        }
        
        return ans;
        
    }
    
    
    // 对BST进行中序遍历（左子树，根节点，右子树），获得BST上从小到大的所有元素
    public void inTraversal(TreeNode root, List<Integer> nums) {
        
        if (root == null) {
            return;
        }
        
        inTraversal(root.left, nums);
        nums.add(root.val);
        inTraversal(root.right, nums);
    }
}
