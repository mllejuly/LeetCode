class Solution {
    public String longestPalindrome(String s) {
        
        String pal = "";
        
        for (int i = 0; i < s.length(); i++) {
            String oddPal = expandCenter(s, i, i);
            String evenPal = expandCenter(s, i, i+1);
            
            if (oddPal.length() > pal.length()) {
                pal = oddPal;
            }
            if (evenPal.length() > pal.length()) {
                pal = evenPal;
            }
            
        }
        return pal;
    }
    
    private String expandCenter(String s, int l, int r) {
        
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l--;
            r++;
        }
        
        return s.substring(l+1, r);
    }
}
