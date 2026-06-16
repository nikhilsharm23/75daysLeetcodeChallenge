class Solution {
    public int maxProduct(int[] nums) {
        int maxend = nums[0];
        int minend = nums[0];
        int ans  = nums[0];
        int i = 0;

        for(i = 1; i < nums.length; i++){
            int v1 = nums[i];
            int v2 = minend * nums[i];
            int v3 = maxend * nums[i];

            maxend = Math.max(v1,Math.max(v2,v3));
            minend = Math.min(v1,Math.min(v2,v3));

            ans = Math.max(maxend , ans);
        }
        return ans;
    }
}