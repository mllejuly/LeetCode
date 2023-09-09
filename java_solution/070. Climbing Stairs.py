class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        l = [0] * (n + 1)
        l[0] = 1
        l[1] = 1
        
        i = 2
        while i <= n:
            l[i] = l[i-2] + l[i-1]
            i += 1
        
        return l[-1]
