class Solution:
    def longestCommonPrefix1(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        
        result = ""
        
        i = 0
        while True:
            try:
                sets = set(str[i] for str in strs)
                if len(sets) == 1:
                    result += sets.pop()
                    i += 1
                else:
                    break
                    
            except Exception as e:
                break
        
        return result
    
    
    
    def longestCommonPrefix2(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        
        # in case of empty input list
        if not strs:
            return ""
        
        for i in range(len(strs[0])):
            for str in strs[1:]:
                if i >= len(str) or str[i] != strs[0][i]:
                    return strs[0][:i]
        
        # in case of the first string in the input list is ""
        return strs[0]
    
    
    
