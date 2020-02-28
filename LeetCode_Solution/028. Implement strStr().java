// 脸书,字符串处理,苹果,微软,基本实现,Pocket Gems


class Solution {
    public int strStr(String haystack, String needle) {
        
        // 1. boundary case
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        
        if (haystack.length() < needle.length()) {
            return -1;
        }
        
        
        // 2. 双指针比较
        // 注意 i 的范围
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                // 比较 haystack 和 needle 当前字符串是否相等
                // 如果不相等则移动 haystack 指针 i, 找到相同的之后再持续比较后续字符
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                
            }
            
            // 如果符合的长度等于needle的长度，则说明 haystack包含完整的 needle
            // 说明找到，返回当前 haystack 的指针位置 i
            if (j == needle.length()) {
                return i;
            }
        }
        
        // 3. 没有找到子字符串返回 -1
        return -1;
    }
}
