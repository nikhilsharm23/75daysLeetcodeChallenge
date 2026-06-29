class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = bin(nums , target , true);
        int last = bin(nums , target , false);

        return new int[]{first , last};
    }

    public int bin(int[] nums , int target , boolean firstOccurance){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;

        while(low <= high){
            int mid = low + ( high - low) / 2;

            if(nums[mid] == target){
                ans = mid;

                if(firstOccurance){
                    high = mid -1; // left search
                    
                } else {
                    low = mid + 1; // right search
                }
            } else if (nums[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }
}