class Solution {
    /**
     * param n: As description.
     * return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {
        
        ArrayList<String> results = new ArrayList<String>();
        
        for (int i = 1; i <= n; i++) {
            
            //能同时被3跟5整除的数，肯定也能被3整除，也能被5整除，所以要先判断能否被15整除
            if (i % 15 == 0) {
                results.add("FizzBuzz");
            } 
            
            // 被5整除，加Buzz
            else if (i % 5 == 0) {
                results.add("Buzz");
            } 
            
            // 被3整除，加Fizz
            else if (i % 3 == 0) {
                results.add("Fizz");
            } 
            
            // 不被3也不被5整除，加数字本身 i
            else {
                results.add(String.valueOf(i));
            }
        }
        return results;
    }
}
