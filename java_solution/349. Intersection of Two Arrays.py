class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        
        nums1 = set(nums1)
        nums2 = set(nums2)
        
        return [x for x in nums2 if x in nums1]
