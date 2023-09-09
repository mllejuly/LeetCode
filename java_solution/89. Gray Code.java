class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        return helper(n, result);
    }
    
    private List<Integer> helper(int n, List<Integer> result) {
        if (n == 0) {
            result.add(0);
            return result;
        }
        
        result = helper(n - 1, result);
        int k = 1 << (n - 1);
        int size = result.size();
        for (int i = size - 1; i >= 0; i--) {
            result.add(result.get(i) + k);
        }
        return result;
    }
}
