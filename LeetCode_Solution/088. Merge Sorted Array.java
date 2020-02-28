class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        // 反向操作
        // 使用两个指针分别对数组从小到大遍历，每次取二者中较小的放在新数组中。
        // 直到某个指针先到结尾，另一个数组中剩余的数字直接放在新数组后面。
        // 时间复杂度O(n)
        
        // 因为assume nums1 空余位足够多，所以不会overwrite nums1
        while (i >= 0 && j >= 0) {
            // nums1当前数字大，写入nums1当前数字
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            }
            // nums2当前数字大，写入nums2当前数字
            else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        
        // 如果nums1 数字全部写完，则nums2数字依次全部写入nums1前端
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}
