class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> charSet = new HashSet<>();
        int windowLength = 0;
        int l = 0;
        int r = 0;
        
        while (r < s.length()) {
            if (!charSet.contains(s.charAt(r))) {
                charSet.add(s.charAt(r));
                r++;
                windowLength = Math.max(windowLength, r - l);
            } else {
                charSet.remove(s.charAt(l));
                l++;
            }
        }
        
        return windowLength;
    }
}

// Sliding Window
// time : O(n)
// space: O(k), k is the set of the Set
