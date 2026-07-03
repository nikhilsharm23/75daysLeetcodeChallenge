class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int guess = low + (high - low) / 2;

            if (nums[guess] == target) {
                return guess;
            }

            // Logic for handling the rotated array
            if (nums[guess] > nums[n - 1]) {
                // Part 1: Left side of the rotation point
                if (nums[guess] < target) {
                    low = guess + 1; // Search right
                } else {
                    if (nums[0] > target) {
                        low = guess + 1; // Search right
                    } else {
                        high = guess - 1; // Search left
                    }
                }
            } else {
                // Part 2: Right side of the rotation point
                if (nums[guess] > target) {
                    high = guess - 1;
                } else {
                    if (nums[n - 1] < target) {
                        high = guess - 1;
                    } else {
                        low = guess + 1;
                    }
                }
            }
        }
        return -1;
    }
}