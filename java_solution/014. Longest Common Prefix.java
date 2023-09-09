class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // 以数组中第一个字符串为基准，后续字符串都和第一个比较即可
        String p = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            
            // 判断每个字符串中的字母的指针j，必须小于当前比较的字符串和首个字符串的小者
            // 然后判断当前字符串的同位置的字符和基准字符是否相等
            while (j < strs[i].length() && j < p.length() && strs[i].charAt(j) == p.charAt(j)) {
                j++;
            }
            
            // 如果没有字符串相同，返回空字符串
            if (j == 0) {
                return "";
            }
            
            // 有字符串相同，以首字符串为基准，返回相同的最大子串
            p = p.substring(0,j);
        }
        
        return p;
    }
} 

