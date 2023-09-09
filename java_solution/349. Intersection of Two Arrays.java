// 二分法,脸书,Two Sigma,排序,优步,两根指针,哈希表



// Built-in Set Intersection
// time complexity: O(n+m) in the average case and O(n×m) in the worst case.

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) {
            set2.add(n);
        }
        
        set1.retainAll(set2);
        
        int[] result = new int[set1.size()];
        int i = 0;
        for (int s : set1) {
            result[i] = s;
            i++;
        }
        
        return result;
    }
}

