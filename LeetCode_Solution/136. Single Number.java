

// XOR，Bit Manipulation
// 0 ^ N = N
// N ^ N = 0
// Time complexity : O(n). We only iterate through nums, so the time complexity is the number of elements in nums.
// Space complexity : O(1).

class Solution {
    public int singleNumber(int[] nums) {
        
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        
        return result;
    }
}
