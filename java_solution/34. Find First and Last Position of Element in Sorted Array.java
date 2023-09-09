class Solution {    
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if(nums[mid] < target) {
                start = mid + 1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid;
                end = mid;
                while(start - 1 >= 0 && nums[start - 1] == target)
                    start--;
                while(end + 1 < nums.length && nums[end + 1] == target)
                    end++;
                break;
            }
        }
        
        if(nums[start] == target) {
            result[0] = start;
            result[1] = end;
        }
        
        return result;
    }
}
