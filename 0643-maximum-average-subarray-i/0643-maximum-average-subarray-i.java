class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        
        // first k elements ka sum
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        int maxSum = sum;

        // sliding window
        for(int i = k; i < n; i++){
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    
}