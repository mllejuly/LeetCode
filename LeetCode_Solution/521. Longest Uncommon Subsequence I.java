class Solution {
    
    // Tag: 字符串处理, 谷歌
    
    public int findLUSlength(String a, String b) {
        
        // 当两个串的长度不相等时，返回较长串的长度，否则返回-1
        if (a.equals(b)) {
            return -1;
        }
        
        else {
            return Math.max(a.length(), b.length());
        }
        
    }
}
