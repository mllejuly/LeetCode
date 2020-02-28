class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        res = 0
        for i in nums:
            res = res ^ i
        return res
 
 # 按位运算符是把数字看做二进制数来进行计算
 # ^ 按位异或，相同得0，不同得1，遍历数组最后剩下的值是只出现过一次的值
