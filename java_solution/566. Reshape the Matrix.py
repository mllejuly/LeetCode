class Solution:
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        rtype: List[List[int]]
        """
        if len(nums) * len(nums[0]) != r * c:
            return nums
        else:
            onerow = [nums[i][j] for i in range(len(nums)) for j in range(len(nums[0]))]
            return [onerow[t * c: (t+1) * c] for t in range(r)]
 
 # 将数组转换为1行，然后根据要转换的行列数进行转换
