class Solution {
    public int reverse(int x) {
        
        int revNum = 0;
        int preNum = 0;
        
        while (x != 0) {
            preNum = revNum;
            int curDigit = x % 10;
            revNum = preNum * 10 + curDigit;
            x /= 10;
            
            // returns 0 when revNum overflows
            if ((revNum - curDigit) / 10 != preNum) {
                return 0;
            }
            
        }
        
        return revNum;
    }
}
