class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnd = nums[0];
        int minEnd = nums[0];

        int maxSum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            maxEnd = Math.max(nums[i], maxEnd + nums[i]);
            maxSum = Math.max(maxSum, maxEnd);

            minEnd = Math.min(nums[i], minEnd + nums[i]);
            minSum = Math.min(minSum, minEnd);
        }

        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}