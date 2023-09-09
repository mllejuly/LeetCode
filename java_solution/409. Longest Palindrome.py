class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = 0
        for v in collections.Counter(s).values():
            n += v // 2 * 2
            if n % 2 == 0 and v % 2 == 1:
                n += 1
        return n
