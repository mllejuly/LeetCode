/*
Power of Two
1 = 2^0 0001
2 = 2^1 0010
4 = 2^3 0100
8 = 2^4 1000
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) 
            return false;
        
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        
        return count == 1;
    }
    
    
    public boolean isPowerOfTwo_2(int n) {
        double i = 1;
        
        while (i < n) {
            i *= 2;
        }
        
        return i == n;
    }
    
    
}


