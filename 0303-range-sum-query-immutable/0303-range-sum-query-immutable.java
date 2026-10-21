class NumArray {
    int prefix[];
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
 
        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) {
            return prefix[right]; // edge case agr left 0 hai to left - 1 err dega
        }

        return prefix[right] - prefix[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */