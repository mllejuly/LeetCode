public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }

        int[][] result = new int[n][n];

        // colomn index
        int x = 0;
        // row index
        int y = 0;
        int num = 1;

        while (n > 0) {
            if (n == 1) {
                result[y][x] = num++;
                break;
            }
            
            // 1, 2
            for (int i = 0; i < n - 1; i++) {
                result[y][x + i] = num++;
            }
            
            // 3, 4
            for (int i = 0; i < n - 1; i++) {
                result[y + i][x + n - 1] = num++;
            }
            
            // 5, 6
            for (int i = 0; i < n - 1; i++) {
                result[y + n - 1][x + n - 1 - i] = num++;
            }

            // 7, 8
            for (int i = 0; i < n - 1; i++) {
                result[y + n - 1 - i][x] = num++;
            }

            x++;
            y++;
            n = n - 2;
        }

        return result;
    }
}
