class Solution(object):

    digits_map = {"2": "abc", "3": "def", 
                  "4": "ghi", "5": "jkl", "6": "mno", 
                  "7": "pqrs", "8": "tuv", "9": "wxyz"}

    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        if len(digits) == 0:
            return []
        result = []
        self.getCombination(digits, 0, "", result)
        return result

    def getCombination(self, inputDigits, i, combinationStr, result):
        if len(combinationStr) == len(inputDigits):
            result.append(combinationStr)
            return
        
        candidate_letters = self.digits_map[inputDigits[i]]
        for letter in candidate_letters:
            combinationStr += letter
            self.getCombination(inputDigits, i+1, combinationStr, result)
            combinationStr = combinationStr[:-1]
