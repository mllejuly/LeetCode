class Solution {
    
    public int numDistinctIslands(int[][] grid) {
        Set<String> visitedIsland = new HashSet<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder islandPath = new StringBuilder();
                    dfs(grid, i, j, 0, 0, islandPath);
                    if (!visitedIsland.contains(islandPath.toString())) {
                        count++;
                        visitedIsland.add(islandPath.toString());
                    }
                }
            }
        }
        return count;
    }
    
    // (xPos, yPos) : absolute position to record visited pos
    // (xPathPos, yPathPos) : relative position to record path shape
    private void dfs(int[][] grid, int xPos, int yPos, int xPathPos, int yPathPos, StringBuilder islandPath) {
        grid[xPos][yPos] = 0;
        islandPath.append(xPathPos + "" + yPathPos);
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int[] dir : dirs) {
            int nextX = xPos + dir[0];
            int nextY = yPos + dir[1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length 
                || grid[nextX][nextY] == 0) {
                continue;
            }
            dfs(grid, nextX, nextY, xPathPos + dir[0], yPathPos + dir[1], islandPath);
        }
    }
}
