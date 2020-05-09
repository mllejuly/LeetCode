class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
       
        if (s.length() < 3) {
            return s.length();
        }
        
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 2;
        
        while (right < s.length()) {
            // update right
            if (map.size() <= 2) {
                map.put(s.charAt(right), right);
                right++;
            }
            // update left
            if (map.size() > 2) {
                int deleteLeft = Collections.min(map.values());
                map.remove(s.charAt(deleteLeft));
                left = deleteLeft + 1;
            }
            
            maxLen = Math.max(maxLen, right - left);
            
        }
        
        return maxLen;
        
    }
}

///////////////////////////////////////////////////////////////////////////////////
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
