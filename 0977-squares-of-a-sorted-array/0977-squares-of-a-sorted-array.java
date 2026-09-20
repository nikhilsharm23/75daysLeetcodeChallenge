class Solution {
    public int[] sortedSquares(int[] nums) {
       int n = nums.length;
       int[] res = new int[n];

       int left  = 0;
       int right  = n - 1;
       int idx = n -1;


       while(left <= right){
        int leftsqr  = nums[left] * nums[left];
        int rightsqr  = nums[right] * nums[right];


        if(leftsqr > rightsqr){
            res[idx] = leftsqr;
            left++;   
        }
        else{
            res[idx] = rightsqr;
            right--;
        }

        idx--;
       }

       return res;
    }
}