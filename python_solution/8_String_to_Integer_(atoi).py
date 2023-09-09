class Solution(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        sign = 1
        i = 0
        n = len(s)

        # skip heading spaces
        while i < n and s[i] == ' ':
            i += 1

        # confirm sign
        if i < n and s[i] == '+':
            i += 1
        elif i < n and s[i] == '-':
            sign = -1
            i += 1
        
        # tranverse digits
        while i < n and s[i].isdigit():
            print(s[i])
            digit = int(s[i])
            if self.isOverflow(result, digit):
                return pow(2, 31) - 1 if sign > 0 else -pow(2, 31)
            result = result * 10 + digit
            i += 1
        return sign * result

    def isOverflow(self, n, digit):
        int_max = pow(2, 31) - 1
        if ((n > int_max // 10) or (n == int_max // 10 and digit > int_max % 10)):
            return True
        else:
            return False

