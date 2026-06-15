class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (fast != 1) {
            slow = getSum(slow);

            fast = getSum(fast);
            fast = getSum(fast);

            if (slow == fast && slow != 1) {
                return false;
            }
        }

        return true;
    }

    private int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}