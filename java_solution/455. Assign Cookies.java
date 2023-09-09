class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i, j;
        
        for (i = j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}
