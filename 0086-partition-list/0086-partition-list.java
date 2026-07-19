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
    public ListNode partition(ListNode head, int x) {
        ListNode firsthead = new ListNode(0);
        ListNode firsttail = firsthead;


        ListNode secondhead = new ListNode(0);
        ListNode secondtail = secondhead;


        ListNode curr = head;

        while(curr != null){
            if(curr.val < x){
                firsttail.next = curr;
                firsttail = firsttail.next; 
            }
            else{
                secondtail.next = curr;
                secondtail = secondtail.next;
            }

            curr = curr.next;
        }

        secondtail.next = null; // last last assign to  null 

        firsttail.next = secondhead.next;

        return firsthead.next;

    }
}