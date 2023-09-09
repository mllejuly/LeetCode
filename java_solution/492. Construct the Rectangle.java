class Solution {
    public int[] constructRectangle(int area) {
        int W = (int)Math.sqrt(area);
        
        while (area % W != 0)
            W--;
        int L = area / W;
        
        return new int[]{L, W};
        
    }
}


// 对于一个面积为S的区域，其长L应大于等于sqrt(S)sqrt(S)，其宽W应小于等于sqrt(S)sqrt(S)。
// 只需要在sqrt(S)sqrt(S)的附近寻找两个最近的能被S的整除的数即可。
