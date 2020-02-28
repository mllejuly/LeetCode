// 两根指针,Zenefits,字符串处理,优步,脸书,领英,微软
// 给定一个字符串，判断其是否为一个回文串。只考虑字母和数字，忽略大小写


class Solution {
    public boolean isPalindrome(String s) {
        // 空字符串返回True
        if  (s == null || s.length() == 0) {
            return true;
        }
        
        // 从前往后遍历的指针
        int i = 0;
        // 从后往前遍历的指针
        int j = s.length() - 1;
        
        // 循环在两个指针相遇时结束
        while (i < j) {
            // 从前到后遍历，如果当前字符不是字母，则指针向后移动一位
            while (i < s.length() && !isValid(s.charAt(i))) {
                i++;
            }

            // for string only cantains punctuation
            if (i == s.length()) {
                return true;
            }

            // 从后往前遍历，如果当前字符不是字母，则指针向前移动一位
            while (j >= 0 && !isValid(s.charAt(j))) {
                j--;
            }

            
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                break;
            }
            else {
                i++;
                j--;
            }
        }
        
        // 如果两个指针可以相遇或者重合，即原字符串是回文
        return j <= i;
    }
    
    // helper, 判断当前字符是否是字母或者数字，因为需要跳过标点和空格
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
    
}

