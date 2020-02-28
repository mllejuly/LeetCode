// LC172. Factorial Trailing Zeroes
class Solution172 {
    public int trailingZeroes(int n) {
        // base case
        if (n < 5) {
            return 0;
        }
        // recursion
        return (n / 5) + trailingZeroes(n / 5);
    }
}



