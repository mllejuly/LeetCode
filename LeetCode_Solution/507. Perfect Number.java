class Solution {
    
    // Tag: Math, Fallible
    
    // 我们定义完美数是一个正整数，它等于除其自身之外的所有正约数的总和。
    // 现在，给定一个整数n，写一个函数，当它是一个完美的数字时返回true，而当它不是时，返回false。
        
    public boolean checkPerfectNumber(int num) {
        
        // Boundary Conditions
        if (num == 1) {
            return false;
        }
        
        int sum = 1;
        // 找到小于sqrt(n)的约数
        for (int i = 2; i * i <= num; i++) {
            
            if (num % i == 0) {
                // 比如36的所有约数1,2,3,6,12,18, 6在中间只能算一次
                if (i * i == num) {
                    sum += i;
                }
                else {
                    // 取出所有约数
                    sum += i + num / i;
                }
            }
            
            if (sum > num) {
                return false;
            }
            
        }
        
        return num == sum;
    
    }
}
