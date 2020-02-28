class Solution:
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        all_same = [a == b for (a,b) in zip(nums, sorted(nums))]
        if all(all_same):
            return 0
        else:
            return len(nums) - all_same.index(False) - all_same[::-1].index(False)


# [::-1]翻转列表
