// 亚马逊,微软
// 计算小于非负数n的质数的个数
// 一种比较好的质数筛选方法：埃拉托斯特尼筛法,然后定义一个boolean数组记录

class Solution {
    public int countPrimes(int n) {
        
        if (n <= 1) {
            return 0;
        }
        
        int result = 0;
        boolean[] notPrime = new boolean[n];
        
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                result++;
                
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
                
            }
        }
        return result;
    }
}
