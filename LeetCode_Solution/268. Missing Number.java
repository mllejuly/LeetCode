class Solution {
    public int missingNumber(int[] nums) {
        // 1. 处理数组 nums，对 nums 进行排序
        Arrays.sort(nums);
        
        // 2. bridge case
        // 确认数组的末位不是 n，否则返回 n
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        // 确认数组的首位不是 0，否则返回 0
        if (nums[0] != 0) {
            return 0;
        }
        
        // 3. 找到 missing number
        // 将 next expect number 和 next real number 进行比较，发现不相等时返回 expect number 即 missing number
        for (int i = 1; i < nums.length; i++) {
            int e = nums[i - 1] + 1;
            if (nums[i] != e) {
                return e;
            }
        }
        
        // 数组没有缺失的数字，返回 -1
        return -1;
        
    }
}
