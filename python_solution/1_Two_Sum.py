class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        visited = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in visited:
                return [i, visited[complement]]
            visited[nums[i]] = i
        return []
