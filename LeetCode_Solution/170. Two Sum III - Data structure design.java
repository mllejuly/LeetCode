class TwoSum {

    private Map<Integer, Integer> map = new HashMap<>();
    // space: O(n)
    
    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    // time: O(1)
    
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Record curNum and curComplemrnt
            int curNum = entry.getKey();
            int curComplement = value - curNum;
            
            if (curComplement == curNum) {
                if (entry.getValue() > 1) {
                    return true;
                } 
            } else if (map.containsKey(curComplement)) {
                return true;
            }
        }
        
        // No complement find for entire map: return false
        return false;
    }
    // time: O(n)
    
}


/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
