Time complexity : O(n^2). For each element, we try to find its complement by looping through the rest of array which takes O(n) time. 
Therefore, the time complexity is O(n^2).

Space complexity : O(1).

// BruteForce
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        
        throw new IllegalArgumentException("No two sum solution");
        
    }
}


// TwoPassHashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // 主要思路是迭代nums的每一个数字的时候，去判断其和目标数字的补数是不是在nums里
        
        // 创建一个哈希表,记录nums数组数字出现的值和位置
        Map<Integer, Integer> map = new HashMap<>();
        
        // 注意取数组的长度用length
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // 如果当前迭代数字的补数在哈希表中出现了，那么说明找到结果，返回补数位置和当前数字位置
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            // 如果当前迭代数字的补数在哈希表中没有出现，则把当前数字的值和位置记入到哈希表
            map.put(nums[i], i);
            
        }
        
        // 如果迭代结束还没有找到任何数的补数，则抛出异常结束程序
        // 注意IllegalArgumentException不要拼错了_(:з」∠)_
        throw new IllegalArgumentException("No two sum solution");
    }
}

