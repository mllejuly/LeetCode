// 爱彼迎,数学,谷歌

class Solution {
    public String addStrings(String num1, String num2) {
        
        // 1. Initialize
        // 创建储存结果的 result
        StringBuilder result = new StringBuilder();
        // 分别获得大数的位数
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 储存当前位的计算结果
        int curr = 0;
        
        // 2. 逐位相加
        // 2.1 通过charAt 获得两个大数的每一位数字的字符形式，从末位开始逐位相加
        while (i >= 0 || j >= 0) {
            char c1 = (i >= 0) ? num1.charAt(i) : '0';
            char c2 = (j >= 0) ? num2.charAt(j) : '0';
            // 2.2 convert char to int
            curr += c1 - '0' + c2 - '0';
            // 2.3 当前位计算结果存到result string
            result.append(curr % 10);
            // 2.4 检查进位情况，如有进位则carry到下一位
            curr /= 10;
            // 2.5 遍历下一位
            j--;
            i--;
        }
        
        // 3. 最后的进位
        // 检查最后一位的进位情况，如有进位则首位 +1
        if (curr > 0) {
			result.append(curr);
        }
        
        // 4. 处理结果格式
        // 反转字符串并转化为字符串，转化成结果要求的格式
        return result.reverse().toString();
    }
}
