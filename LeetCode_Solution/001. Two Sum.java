//////////////////////////////////////////////////////////////////////////////////////

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1. Initialize HashMap (key: nums[i], value: i)
        Map<Integer, Integer> map = new HashMap<>();
        
        // 2. Iterate the nums array
        for (int i = 0; i < nums.length; i++) {
            // 2-1. Record curNum and curComplemrnt
            int curNum = nums[i];
            int curComplement = target - curNum;
            // 2-2. Check the existence of curComplement
            if (map.containsKey(curComplement)) {
                // 2-2-1. curComplement find: return index
                return new int[] {map.get(curComplement), i};
            } else {
                // 2-2-2. curComplement not find: add to map and continue
                map.put(curNum, i);
            }
        }
        
        // 3. No complement find for entire array: throw Exception info
        throw new IllegalArgumentException("No two sum solution");
        
    }
}

// time:  O(n)
// space: O(n)

//////////////////////////////////////////////////////////////////////////////////////

    
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


