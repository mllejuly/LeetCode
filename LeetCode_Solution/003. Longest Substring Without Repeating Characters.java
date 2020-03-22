//////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int result = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        
        int n = s.length();
        while (leftIdx < n && rightIdx < n) {
            
            if (!set.contains(s.charAt(rightIdx))) {
                set.add(s.charAt(rightIdx));
                rightIdx++;
                result = Math.max(result, rightIdx - leftIdx);
            } else {
                set.remove(s.charAt(leftIdx));
                leftIdx++;
            }
            
        }
        
        return result;
    }
}
//////////////////////////////////////////////////////////////////////////////////////

// Sliding Window
// time : O(n)
// space: O(k), k is the set of the Set
