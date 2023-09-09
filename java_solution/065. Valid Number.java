class Solution {
    
    public boolean isNumber(String s) {
        
        // count & position
        // num : at least 1 time
        // exp : can only appear 1 time, between numbers
        // sign: appear at index 0 || before exp
        // dec : can only appear 1 time
        
        // skip heading/trailing whitespace
        s = s.trim();
        
        boolean num = false;
        boolean exp = false;
        boolean numAfterExp = false;
        // boolean sign = false;
        boolean dec = false;
        
        for (int i = 0; i < s.length(); i++) {
            
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                num = true;
                
                if (exp) {
                    numAfterExp = true;
                }
                
            } else if (s.charAt(i) == '.') {
                // " 99e2.5 " -> exp before dec -> false
                if (exp || dec) {
                    return false;
                }
                dec = true;
            } else if (s.charAt(i) == 'e') {
                // "e3" -> false
                if (exp || !num) {
                    return false;
                }
                numAfterExp = false;
                exp = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                // " 6e-1" -> true
                // " --6 " -> false
                // "-+3" -> false
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                // "1 a" -> false
                // "95a54e53" -> false
                return false;
            }
            
        }
        
        // " 1e" -> false
        return num && ( (exp && numAfterExp) || (!exp && !numAfterExp) );
        
    }
}

// time : O(n)
// space: O(1)
