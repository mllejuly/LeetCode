class Solution {
    
    public boolean isPalindrome(String s) {
        // 1. Initialize two pointer
        int i = 0;
        int j = s.length() - 1;
        
        // 2. Iterate the string
        while (i < j) {
            // skip non-alphanumeric characters
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            // check
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
            
        }
        
        // 3. Finish checking all, return true
        return true;
    }

}

// time : O(n)
// space: O(1)
