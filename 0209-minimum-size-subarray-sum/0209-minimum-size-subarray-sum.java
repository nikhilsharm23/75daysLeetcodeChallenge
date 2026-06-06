class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0;
        int res = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++){
            sum = sum + nums[right];
            
            // shrink 
            while(sum >= target){
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}