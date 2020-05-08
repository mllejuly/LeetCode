class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Sliding Window
        int l = 0;
        int r = -1;
        int maxLen = 0;
            
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            } else {
                // update left boundary
                if (r >= 0 && s.charAt(i) != s.charAt(r)) {
                    maxLen = Math.max(i - l, maxLen);
                    l = r + 1;
                }
                // update right boundary
                r = i - 1;
            }
        }
        
        return Math.max(s.length() - l, maxLen);                            
    }
}
