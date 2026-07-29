class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[n - k + 1];

        // First window
        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        result[0] = nums[deque.peekFirst()];

        // Remaining windows
        for (int i = k; i < n; i++) {

            // Remove elements out of window
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            result[i - k + 1] = nums[deque.peekFirst()];
        }

        return result;
    }
}