class Solution {
    public boolean isAnagram(String s, String t) {
        
        // 1. boundary case
        if (s.length() != t.length()) {
            return false;
        }
        
        // 2. 将字符串转化成数组，然后利用Arrays.sort()对数组进行排序
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        // 3. 判断两字符串数组是否相等
        return Arrays.equals(str1, str2);
    }
}
