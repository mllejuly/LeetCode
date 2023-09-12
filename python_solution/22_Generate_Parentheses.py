class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
        self.backtracking("", 0, 0, n, result)
        return result
    
    def backtracking(self, s, open_count, close_count, n, result):
        # stop point
        if len(s) == 2 * n:
            result.append(s)
            return
        
        # confirm options
        if open_count < n:
            # extend path
            s += "("
            self.backtracking(s, open_count+1, close_count, n, result)
            # backtracking
            s = s[:-1]
        # confirm options
        if close_count < open_count:
            # extend path
            s += ")"
            self.backtracking(s, open_count, close_count+1, n, result)
            # backtracking
            s = s[:-1]
        
