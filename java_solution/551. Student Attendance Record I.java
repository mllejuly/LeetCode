class Solution {
    // tag: 字符串处理,谷歌,Split String
    
    // 遍历字符串来判断
    // 1. 有超过一个'A' 
    // 2. 连续三个及以上'L' 
    public boolean checkRecord(String s) {
        
        int count_A = 0;
        
        s += "##";
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                count_A++;
            }
            
            if (count_A > 1 || ( s.charAt(i) == 'L' && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L' )) {
                return false;
            }
        }
        
        return true;
    }
}
