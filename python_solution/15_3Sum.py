class Solution(object):
    def threeSum(self, nums):
        result = []
        nums.sort()
        for i in range(len(nums)):
            if nums[i] > 0:
                break
            # skip duplicate num
            if i == 0 or nums[i] != nums[i-1]:
                self.twoSum(nums, i, result)
        return result

    def twoSum(self, nums, i, result):
        visited = set()
        j = i+1
        while j < len(nums):
            complement = -nums[i]-nums[j]
            if complement in visited:
                result.append([nums[i], nums[j], complement])
                # skip duplicate num
                while j+1 < len(nums) and nums[j+1] == nums[j]:
                    j += 1
            visited.add(nums[j])
            j += 1
