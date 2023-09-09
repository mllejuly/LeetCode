class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        
        while (l < r) {
            int tmpSum = numbers[l] + numbers[r];
            if (tmpSum < target) {
                l++;
            } else if (tmpSum > target) {
                r--;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}

// time  : O(n)
// space : O(1)
