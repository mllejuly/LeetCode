// Dynamic Programming
// time : O(mn)
// space: O(mn)
class Solution {
    public int minDistance(String word1, String word2) {
        
        int l1 = word1.length();
        int l2 = word2.length();
        
        if (l1 == 0 || l2 == 0) {
            return l1 + l2;
        }
        
        int[][] step = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            step[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            step[0][j] = j;
        }
        
        // dp
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    step[i][j] = step[i - 1][j - 1];
                } else {
                    int preLeft = step[i - 1][j];
                    int preDown = step[i][j - 1];
                    int preLeftDown = step[i - 1][j - 1];
                    step[i][j] = min(preLeft, preDown, preLeftDown) + 1;
                }
                
            }
        }
        
        return step[l1][l2];
        
    }
    
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    
}
