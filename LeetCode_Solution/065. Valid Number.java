class Solution {
    public boolean isNumber(String s) {
        
        s = s.trim();

        boolean dec = false;
        boolean exp = false;
        boolean num = false;
        boolean numAfterExp = false;
        
        for(int i = 0; i < s.length(); i++) {
        
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
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
                // valid exp: no exp before cur exp; cannot appear before num
                if (exp || !num) {
                    return false;
                }
                numAfterExp = false;
                exp = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                // valid sign: can only appear in the beginning; cannot follow directly after exp
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
