class Solution {
    public String reverseStr(String s, int k) {
        
        // 字符串处理，谷歌
        
        char[] a = s.toCharArray();

        for (int start = 0; start < a.length; start += 2 * k) {
            
            int i = start;
            
            // 反转从字符串开头起的每2k个字符中的前k个字符
            // 如果剩下少于k个字符，则反转所有字符
            int j = Math.min(start + k - 1, a.length - 1);
            
            while (i < j) {
                char tmp = a[i];
                a[i] = a[j];
                i++;
                a[j] = tmp;
                j--;
            }            
        }
        return new String(a);
    }
}
