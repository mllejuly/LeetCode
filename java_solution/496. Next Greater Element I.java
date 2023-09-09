class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // 用栈来储存结果
        Stack<Integer> stack = new Stack<>();
        
        // 遍历nums2中的每一个数字num
        for (int num : nums2) {
            // 当栈非空，且栈顶元素小于当前数字num时
            while ( !stack.isEmpty() && stack.peek() < num) {
                // 记录栈顶元素对应的数字num
                map.put(stack.pop(), num);
            }
            // 直到栈顶元素大于当前数字num，此时将num入栈
            stack.push(num);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
