// 微软,Bloomberg,脸书,优步,数组,亚马逊,贪心,枚举法

class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        // remember the smallest price
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for (int i : prices) {
            min = i < min ? i : min;
            profit = (i - min) > profit ? (i - min) : profit;
        }
        
        return profit;
        
    }
}
