class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null) {
            return 0;
        }
        
        int ans = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> disCount = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                int count = disCount.getOrDefault(distance, 0);
                disCount.put(distance, count + 1);
            }
            
            for (int count : disCount.values()) {
                ans += count * (count - 1);
            }
        }
        return ans;
    }
    
    public int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}



// 两层for循环遍历每两个点，计算两点之间距离，以及可以构成该距离的的个数。
// 用hash表记录Map<distance, count>
// 则该距离下可构成回旋镖的个数为count * (count - 1)
