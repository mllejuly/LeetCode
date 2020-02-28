// 二进制，脸书，字符串处理
// 给定两个二进制字符串，返回他们的和（用二进制表示）。


class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        // 记录 String a 数字位置的指针
        int i = a.length() - 1;
        // 记录 String b 数字位置的指针
        int j = b.length() - 1;
        // 记录进位
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            // 结果首先加进位，再加 a 的数字，再加 b 的数字
            int sum = carry;
            if (i >= 0) {
                // use - '0' convert string to integer
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            // sum 除以2 的余数append到 s，carry进位和下一位的数字 一起求和再运算
            s.append(sum % 2);
            // 检查有无进位，有的话carry到下一个loop
            carry = sum / 2;
        }
        if (carry != 0) {
            s.append(carry);
        }
        return s.reverse().toString();
    }
}
