class Solution {

    public long totalHours(int[] piles, int k) {
        long hours = 0;

        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) {
                hours++;
            }
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = totalHours(piles, mid);

            if (hours > h) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }
}