class Solution {
    
    // Tag: 字符串处理, Google
    
    // 遍历字符串时对大小写字母进行统计，当遇到如下两种情况应返回false:
    // 1. 首字母小写但出现了一个大写字母
    // 2. 大写字母数量超过一个且出现了小写字母
        
    public boolean detectCapitalUse(String word) {
        int countUpper = 0;
        int countLower = 0;
        
        // 定义flag： 首字母是大写字母
        boolean flag = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        
        for (int i = 0; i < word.length(); i++) {
            // 如果当前字母是大写字母
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                countUpper++;
                // 当前字母是大写字母，有小写字母，首字母小写
                if (i !=0 && countLower > 0 && !flag) {
                    return false;
                }
                
                // 有小写字母，有超过一个的大写字母
                if (countLower > 0 && countUpper > 1) {
                    return false;
                }
            }
            // 当前字母不是大写字母，开始出现小写字母，如果已经出现的大写字母个数大于1，则返回false
            else {
                countLower++;
                if (countUpper > 1) {
                    return false;
                }
            }
        }
        
        return true;
        
    }
}
