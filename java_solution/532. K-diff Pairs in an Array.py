class Solution:
    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rype: int
        """
        if k>0:
            return len(set(nums) & set(n+k for n in nums))
        elif k==0:
            return sum(v>1 for v in collections.Counter(nums).values())
        else:
            return 0
            
            
            
# 如果k大于0，则返回两个set的交集
# 如果k=0，则计数，找出出现1次以上的元素的个数
# 如果k小于0，返回0
