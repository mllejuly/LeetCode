class Solution {

    public int myAtoi(String str) {

        str = str.trim();
        
        // handle sign
        int sign = 1;
        int i = 0;
        if (i < str.length() && str.charAt(i) == '+') {
            i++;
            if (i > str.length() - 1 || !Character.isDigit(str.charAt(i))) {        
                return 0;
            }
        }
        if (i < str.length() && str.charAt(i) == '-') {
            sign = -1;
            i++;
            if (i > str.length() - 1 || !Character.isDigit(str.charAt(i))) {        
                return 0;
            }
        }
        
        // get number
        long num = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            num = num * 10 + Character.getNumericValue(str.charAt(i));
            i++;
            // handle overflow
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
