// 二分法,脸书,排序,两根指针,哈希表

// 用map维护前一个数组中每个值出现的次数
// 然后遍历第二个数组，对于每个遍历到的数，在map中将这个数出现的次数-1



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        // 记录nums1 中数字出现的次数，储存在HashMap中
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        
        // 因为不知道结果的长度，所以先建立长度未定的ArrayList, results
        List<Integer> results = new ArrayList<Integer>();
        
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                results.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        
        // 知道长度之后，将结果赋到确定长度的result中
        int[] result = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            result[i] = results.get(i);
        }
        return result;
    }
}

