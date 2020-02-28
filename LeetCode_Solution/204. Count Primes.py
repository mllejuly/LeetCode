class Solution:
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        if n < 3:
            return 0
        
        res = [True] * n
        
        res[0] = res[1] = False
        
        for i in range(2, int(math.sqrt(n))+1):
            res[i*i:n:i] = [False] * len(res[i*i:n:i])
        
        return sum(res)
        
 
 # 统计比n小的质数有多少
 # 设置一个长度为n的list，值全部为True
 # 遍历所有非质数，标记为False
 # 统计True的个数
