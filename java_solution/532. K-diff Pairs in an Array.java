class Solution {
    
    // tag: 亚马逊,哈希表
    
    
    public int findPairs(int[] nums, int k) {
        /**
        * @param nums: an array of integers
        * @param k: an integer
        * @return: the number of unique k-diff pairs
        **/
        
        // Boundary Case边界情况
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        
        // 创建哈希表记录数组nums中每个数字出现的个数
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        
        for (int i : nums) {
            // 当map集合初始不存在key = i, 使用默认值defaultValue = 0，并+1
            // 出现一次之后存在key = i, 之后每一次出现都在之前出现次数上+1
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // 遍历数字出现次数的哈希表
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                // 当k-diff为零的时候，统计出现超过一次的数字即为结果
                if (entry.getValue() >= 2) {
                    count++;
                }
            }
            // 当k-diff不为零的时候，哈希表中每出现比当前key大k的数，结果+1
            else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
