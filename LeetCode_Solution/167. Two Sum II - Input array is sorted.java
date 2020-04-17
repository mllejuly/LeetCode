class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        
        while (i < j) {
            int tmpSum = numbers[i] + numbers[j];
            if (tmpSum < target) {
                i++;
            } else if (tmpSum > target) {
                j--;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}

// time  : O(n)
// space : O(1)
