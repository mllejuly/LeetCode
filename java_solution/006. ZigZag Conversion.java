class Solution {
    public String convert(String s, int numRows) {
        
        StringBuffer[] rows = new StringBuffer[numRows];
        
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuffer();
        }
    
        int i = 0;
        while (i < s.length()) {
            // vertically down
            for (int idx = 0; idx < numRows && i < s.length(); idx++) {
                rows[idx].append(s.charAt(i));
                i++;
            }
            // obliquely up
            for (int idx = numRows-2; idx >= 1 && i < s.length(); idx--) {
                rows[idx].append(s.charAt(i));
                i++;
            }
        }
    
        // combine rows
        for (int idx = 1; idx < rows.length; idx++) {
            rows[0].append(rows[idx]);
        }
        
        return rows[0].toString();
    }
}
