class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int  sum2 = 0;

        for(int i = 0; i < nums1.length; i++){
            sum1 += nums1[i];
            sum2 += nums2[i];
        }


        int gain1 = 0;
        int maxgain1 = 0;


        int gain2 = 0;
        int maxgain2 = 0;


        for(int i = 0; i < nums1.length; i++){
            gain1 = Math.max(0 , gain1 + nums2[i] - nums1[i]);
            maxgain1 = Math.max(maxgain1 , gain1);


            gain2 = Math.max(0 , gain2 + nums1[i] - nums2[i]);

            maxgain2 = Math.max(gain2 , maxgain2);

        }


        int ans1 = sum1 + maxgain1;
        int ans2 = sum2 + maxgain2;
        return Math.max(ans1 , ans2);
    }
   
}