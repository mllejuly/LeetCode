class Solution:
    def isHappy(self, n):
        """
        :type n: int
        ;rtypr: bool
        """
        
        c = set()
        while not n in c:
            c.add(n)
            n = sum([int(x)**2 for x in str(n)])
        return n==1
  
 
 # 用列表保存出现过的数，当出现重复的数字的时候，说明出现了循环
 # 循环有两种情况
 # 1. 不是hayyp数，循环的数必不是1
 # 2. 是happy数，那么会出现1的不断循环
