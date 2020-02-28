// 动态规划,苹果,Adobe
// Dynamic Programming

// 考虑最后一步走1阶还是走2阶。
// 方案数Dp[n] = 最后一步走1阶的方案数 + 最后一步走2阶的方案数。
// Dp[n] = Dp[n-1] + Dp[n-2].

class Solution {
    public int climbStairs(int n) {
        // 计算只有一层台阶的情况
        if (n == 1) {
            return 1;
        }
        
        // 定义计算前两级台阶的情况
        // 创建 n 长度的数组
        int[] dp = new int[n];
        // 到第一层台阶有 1 种走法
        dp[0] = 1;
        // 到第二层台阶有 2 种走法
        dp[1] = 2;
        // 计算第三层台阶及以上
        for (int i = 2; i <= n - 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 长度为 n 的数组的最后一位的序号是 n - 1
        return dp[n - 1];
    }
}
