class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        diff = 2 * pow(10, 4)
        nums.sort()
        for i in range(len(nums)):
            l = i + 1
            r = len(nums) - 1
            while (l < r):
                threeSum = nums[i] + nums[l] + nums[r]
                if abs(target-threeSum) < abs(diff):
                    diff = target-threeSum
                if threeSum < target:
                    l += 1
                else:
                    r -= 1
                if diff == 0:
                    return target
        return target-diff
