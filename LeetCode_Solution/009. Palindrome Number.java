class Solution {
    public boolean isPalindrome(int x) {
        
        // 取x的绝对值
        int a = 0;
        a = Math.abs(x);

        // 算出x的reverse number
        int rev = 0;
        while (a != 0) {
            rev = rev * 10 + a % 10;
            a /= 10;
        }
        
        // 在x > 0 且 x == rev才返回T
        if (x >= 0 && x == rev) {
            return true;
        }
        // x < o 返回F
        else {
            return false;
        }
    }
}
