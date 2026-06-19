class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        int left = 0; 

        for(int i = 0; i < n; i++){
            int right = sum - nums[i] - left;

            if(right == left){
                return i;
            }

            left += nums[i];
        }
        return -1;
    }
}