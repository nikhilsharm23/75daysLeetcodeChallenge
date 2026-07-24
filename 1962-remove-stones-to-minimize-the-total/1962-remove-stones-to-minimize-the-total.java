import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int minStoneSum(int[] piles, int k) {
       PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

       for(int pile : piles){
        maxheap.offer(pile);
       }

       while( k > 0){
        int maxCurrentPile = maxheap.poll();

        int stoneremove = maxCurrentPile / 2;
        int remaining = maxCurrentPile - stoneremove;

        // Aapne upar offer() use kiya aur yahan add(), dono kaam same karte hain, 
        // par ek hi method (jaise offer) use karna consistency ke liye acha hota hai.
        maxheap.offer(remaining); 
        k--;
       }

       int total = 0;
       while(!maxheap.isEmpty()){
        total += maxheap.poll(); // "maxheal" ko "maxheap" kar diya
       }

       return total;
    }
}