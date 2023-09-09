class Solution {

    public String reverseWords(String s) {

        if(s.length() == 0 || s == null){
            return "";
        }

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int i = words.length - 1; i >= 0; i--){
            // skip leading/trailing spaces, reduce multiple spaces
            if (!words[i].equals("")) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(words[i]);
            }
        }
        
        return result.toString();
    
    }
}


// time : O(n)
// spcae: O(n)
