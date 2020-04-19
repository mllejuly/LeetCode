class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        for (int i = 0; i < n - m + 1; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        
        return -1;
        
    }
}


// time : O(m * n)
// space: O(1)
