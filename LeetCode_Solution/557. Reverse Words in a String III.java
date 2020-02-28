class Solution {
    public String reverseWords(String s) {
        
        // 1.字符串变成数组
        String words[] = s.split(" ");
        
        // 2.储存结果
        StringBuilder result = new StringBuilder();
        
        // 3.倒置每一个单词
        for (String word : words) {
            // StringBuffer 可重载这些方法以接受任意类型的数据。
            // 每个方法都能有效地将给定的数据转换成字符串，然后将该字符串的字符追加或插入到字符串缓冲区中。
            // reverse() 方法用于颠倒数组中元素的顺序。
            String w = new StringBuffer(word).reverse().toString();
            result.append(w + " ");
        }
        
        // 4. 取出首尾空格，讲结果转化成String
        return result.toString().trim();
    }
}
