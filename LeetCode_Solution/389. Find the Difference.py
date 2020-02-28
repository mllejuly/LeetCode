class Solution:
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        
        l1 = list(s)
        l2 = list(t)
        
        for ch in l1:
            l2.remove(ch)
        
        return "".join(l2)
