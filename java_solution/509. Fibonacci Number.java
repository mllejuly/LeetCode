class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        
        int result = fib(N-1) + fib(N-2);
        return result;
    }
}
