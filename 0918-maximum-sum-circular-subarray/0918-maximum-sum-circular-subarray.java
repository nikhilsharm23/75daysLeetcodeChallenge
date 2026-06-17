class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int totalsum = nums[0];
        int maxend = nums[0];
        int maxsum = nums[0];

        int minend = nums[0];
        int minsum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalsum += nums[i];

            maxend = Math.max(nums[i], maxend + nums[i]);
            maxsum = Math.max(maxsum, maxend);

            minend = Math.min(nums[i], minend + nums[i]);
            minsum = Math.min(minsum, minend);
        }

        if (maxsum < 0) {
            return maxsum;
        }

        return Math.max(maxsum, totalsum - minsum);
    }
}