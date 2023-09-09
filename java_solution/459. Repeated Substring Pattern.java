class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = s.length() / 2 ; i >= 1; i--) {
            
            if (s.length() % i == 0) {
                int m = s.length() / i;
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}


// The length of the repeating substring must be a divisor of the length of the input string
// Search for all possible divisor of str.length, starting for length/2
// If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
// If the repeated substring is equals to the input str return true
