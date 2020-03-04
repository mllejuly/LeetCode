// 490. The Maze
// BFS
// time: O(mn)
// space: O(mn)
class Solution490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            // destination arrived
            if (cur[0] == destination[0] && cur[1] == destination[1]) {
                return true;
            }
            
            // BFS path
            for (int[] dir : dirs) {
                int x = cur[0];
                int y = cur[1];
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length &&
                       maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                // backtracking
                x -= dir[0];
                y -= dir[1];
                if (!visited[x][y]) {
                    queue.add(new int[] {x, y});
                    visited[x][y] = true;
                }
            } 
        }
        return false;
    }
}
