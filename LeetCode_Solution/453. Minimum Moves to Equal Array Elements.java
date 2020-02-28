class Solution {
    public int minMoves(int[] nums) {
        int sumNum = 0;
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            sumNum += num;
            minNum = Math.min(minNum, num);
        }
        return sumNum - minNum * nums.length;
    }
}



// Summary:
// 对于一个长度为n的整型数数组，每步将n-1个元素加1，求最少需要多少步，能使数组中的数字全部相同。

// Analysis:
// 若使数组尽快满足题目要求，则需要每次给除去最大值的其余数字加1，但这种方法效率过低，可以换一种思路。
// 每次将数组中的n-1个数字加1，相当于将剩余的一个数字减1。所以只需找到数组中的最小值m，计算m与数组中其他数字差的累计和即可。


