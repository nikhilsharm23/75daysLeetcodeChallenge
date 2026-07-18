/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        //find middile 
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        // reverse 

        ListNode curr = second;
        ListNode prev = null;

        while(curr != null){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        second = prev;



        // find maz twin 
        ListNode first = head;
        int max = 0;

        while(second != null){
            int sum = first.val + second.val;

            max = Math.max(sum , max);
            first = first.next;
            second = second.next;
        }

        return max;
    }
}