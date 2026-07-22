class Solution {
    public int[] sortArrayByParityII(int[] nums) {

        int even = 0;
        int odd = 1;
        int n = nums.length;

        while (even < n && odd < n) {

            // Even index par already even number hai
            if (nums[even] % 2 == 0) {
                even += 2;
            }

            // Odd index par already odd number hai
            else if (nums[odd] % 2 == 1) {
                odd += 2;
            }

            // Even index par odd aur odd index par even
            else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;

                // Swap ke baad dono pointers aage badhao
                even += 2;
                odd += 2;
            }
        }

        return nums;
    }
}