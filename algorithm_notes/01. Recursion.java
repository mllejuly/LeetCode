// 172. Factorial Trailing Zeroes
class Solution172 {
    public int trailingZeroes(int n) {
        // base case
        if (n < 5) {
            return 0;
        }

        // recursion rule
        return (n / 5) + trailingZeroes(n / 5);
    }
}


// 89. Gray Code
class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        return getGrayCodeList(result, n);
    }
    
    private List<Integer> getGrayCodeList(List<Integer> result, int n) {
        // base case
        if (n == 0) {
            result.add(0);
            return result;
        }
        
        // recursion rule
        result = getGrayCodeList(result, n-1);
        int k = 1 << (n - 1);
        int size = result.size();
        for (int i = size - 1; i >= 0; i--) {
            result.add(result.get(i) + k);
        }
        return result;
    }
}
