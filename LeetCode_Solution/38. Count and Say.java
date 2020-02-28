class Solution {
    public String countAndSay(int n) {
        String s = "1";
        
        while (--n > 0) {
            
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                int count = 1;
                while (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                    count++;
                    i++;
                }
                
                result.append(String.valueOf(count) + String.valueOf(s.charAt(i))); 
            }
            
            s = result.toString();
            
        }
        
        return s;
        
    }
}
