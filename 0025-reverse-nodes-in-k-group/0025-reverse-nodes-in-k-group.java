class Solution {

    private ListNode reverse(ListNode head, int times) {
        ListNode curr = head;
        ListNode prev = null;

        while (times-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = curr;
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode left = head;
        ListNode right;
        ListNode res = null;
        ListNode prevleft = null;

        while (true) {

            right = left;

            for (int i = 1; i < k && right != null; i++) {
                right = right.next;
            }

            if (right == null) {

                if (prevleft != null)
                    prevleft.next = left;

                if (res == null)
                    res = left;

                break;
            }

            ListNode nextleft = right.next;

            ListNode newHead = reverse(left, k);

            if (prevleft != null)
                prevleft.next = newHead;

            if (res == null)
                res = newHead;

            prevleft = left;
            left = nextleft;
        }

        return res;
    }
}