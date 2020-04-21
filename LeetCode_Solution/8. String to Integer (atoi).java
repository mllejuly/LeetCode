class Solution {
    public int myAtoi(String str) {
        
        // 1. skip heading whitespaces
        str = str.trim();

        int i = 0;
        int n = str.length();
        
        // 2. handle sign
        int sign = 1;
        if (i < n && str.charAt(i) == '+') {
            i++;
            if (str.length() - 1 < i || !Character.isDigit(str.charAt(i))) {        
                return 0;
            }
        }
        if (i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
            if (str.length() - 1 < i || !Character.isDigit(str.charAt(i))) {        
                return 0;
            }
        }
        
        // 3. get number by digit
        long num = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            num = num * 10 + Character.getNumericValue(str.charAt(i));
            i++;
            
            // handle overflow [-2147483648, 2147483647]
            if (num > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
        }
        
        int result = (int)num;
        return sign * result;
        
    }
}

// time : O(n)
// space: O(1)
