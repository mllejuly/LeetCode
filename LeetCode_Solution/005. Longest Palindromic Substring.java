class Solution {
    
    public String longestPalindrome(String s) {
    
        String result = "";
        
        for (int i = 0; i < s.length(); i++) {
            
            String oddString = extendCenter(s, i, i);
            String evenString = extendCenter(s, i, i + 1);
        
            if (oddString.length() > result.length()) {
                result = oddString;
            }
            if (evenString.length() > result.length()) {
                result = evenString;
            }
        }
        
        return result;
    }
    
    private String extendCenter(String s, int left, int right) {
    
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    
    }
    
}
