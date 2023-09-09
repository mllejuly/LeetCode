class Solution {
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }
}


// 主要考察异或操作
// 一个二进制数位与0异或等于其本身，与1异或等于将这个数位取反
