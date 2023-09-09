public class Solution1 {
    /**
     * @param n: a non-negative integer
     * @return: the total number of full staircase rows that can be formed
     */
    // n = (1 + x) * x / 2, 求解得 x = (-1 + sqrt(8 * n + 1)) / 2, 答案对x取整
    public int arrangeCoins(int n) {
        // Write your code here
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}

public class Solution2 {
    public int arrangeCoins(int n) {
        int i=0;
        while(n > 0){
            i+=1;
            n-=i;
        }
        
        return n==0 ? i : i-1;
        
    }
}
