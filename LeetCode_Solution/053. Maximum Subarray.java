// Greedy
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
    
        return maxSum;
    }
}
// Time : O(N), it's one pass along the array.
// Space: O(1), it's a constant space solution.




////////////////////////////////////////////////////////////////////////////////////
// 子数组，Bloomberg，微软，数组，领英，贪心，枚举法
class Solution {
    public int maxSubArray(int[] nums) {
        
        // edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // max 储存subarray的历史最大值
        int max = Integer.MIN_VALUE;
        // sum 储存当前subarray的和
        int sum = 0;
        
        
        for (int i = 0; i < nums.length; i++) {
            
            // 如果sum小于0，重置sum的值为0，重新往subarray里加数字
            if (sum < 0) {
                sum = 0;
            }
            
            // 遍历数组nums，逐个把每个数字加到sum里
            sum += nums[i];
            
            // 取当前 subarray 加总值 sum 和历史最大值 max 中较大的那一个
            max = Math.max(max, sum);
        }
        
        return max;
        
    }
}
