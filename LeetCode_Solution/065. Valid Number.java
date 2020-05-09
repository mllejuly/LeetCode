class Solution {
    
    public boolean isNumber(String s) {
        
        // skip heading/trailing whitespace
        s = s.trim();
        
        boolean num = false;
        boolean exp = false;
        boolean numAfterExp = false;
        // boolean sign = false;
        boolean dec = false;
        
        for (int i = 0; i < s.length(); i++) {
            
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                // valid num
                if (exp) {
                    numAfterExp = true;
                }
                num = true;
            } else if (s.charAt(i) == '.') {
                // valid dec: no exp or dec before cur dec
                if (exp || dec) {
                    return false;
                }
                dec = true;
            } else if (s.charAt(i) == 'e') {
                // valid exp: no exp before cur exp; must be followed after a number
                if (exp || !num) {
                    return false;
                }
                numAfterExp = false;
                exp = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                // valid sign: can only appear at 0; cannot follow directly after exp
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            
        }
        
        // valid num with valid exp or no exp
        return num && ( (exp && numAfterExp) || (!exp && !numAfterExp) );
        
    }
}

// time : O(n)
// space: O(1)
