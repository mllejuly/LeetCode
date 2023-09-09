class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        long left = 1;
        long right = Integer.MAX_VALUE;
        
        // BST
        while (true) {
            long mid = left + (right - left)/2;
            
            if (mid * mid > x) {
                right = mid - 1;
            }
            else {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                }
            left = mid + 1;
            }
        }
    }
}

