class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int m = nums1.length;
        int n = nums2.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(nums1, 0, nums2, 0, l) + getkth(nums1, 0, nums2, 0, r)) / 2.0;
	}
    
    
    public double getkth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 > nums1.length - 1) {
            return nums2[s2 + k - 1];
        }
        if (s2 > nums2.length - 1) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (s1 + k/2 - 1 < nums1.length) {
            mid1 = nums1[s1 + k/2 - 1];
        }
        if (s2 + k/2 - 1 < nums2.length) {
            mid2 = nums2[s2 + k/2 - 1];
        }
        
        if (mid1 < mid2) {
            return getkth(nums1, s1 + k/2, nums2, s2,       k - k/2); // Check: r1+ l2
        }
        else {
            return getkth(nums1, s1,       nums2, s2 + k/2, k - k/2); // Check: r2 + l2
        }
    }

}

/***

The key point of this problem is to ignore half part of A and B each step recursively by comparing the median of remaining A and B:
if (aMid < bMid) Keep [aRight + bLeft]    
else Keep [bRight + aLeft]

time: O(log(m + n))

***/
