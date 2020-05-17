class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int num = x;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev == x;
        
    }
}
